package org.michaelbel.template.phonecalls

import android.Manifest
import android.content.Context
import android.database.Cursor
import android.provider.CallLog
import androidx.annotation.RequiresPermission
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Date
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import org.michaelbel.core.ktx.denied
import org.michaelbel.template.phonecalls.model.CallType
import org.michaelbel.template.phonecalls.model.PhoneCallLog

class PhoneCallsManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    @RequiresPermission(Manifest.permission.READ_CALL_LOG)
    fun readCallLog(): List<PhoneCallLog> {
        if (Manifest.permission.READ_CALL_LOG.denied(context)) {
            return emptyList()
        }

        val cursor: Cursor = requireNotNull(
            context.contentResolver.query(
                CallLog.Calls.CONTENT_URI, null, null, null, null
            )
        )

        val numberIndex: Int = cursor.getColumnIndex(CallLog.Calls.NUMBER)
        val typeIndex: Int = cursor.getColumnIndex(CallLog.Calls.TYPE)
        val dateIndex: Int = cursor.getColumnIndex(CallLog.Calls.DATE)
        val durationIndex: Int = cursor.getColumnIndex(CallLog.Calls.DURATION)

        val items: MutableList<PhoneCallLog> = mutableListOf()

        while (cursor.moveToNext()) {
            val number: String = cursor.getString(numberIndex)
            val type: String = cursor.getString(typeIndex)
            val date: String = cursor.getString(dateIndex)
            val duration: String = cursor.getString(durationIndex)

            val callDate: Date = Date(date.toLong())
            val currentDate: Date = Date()

            val toMinutes: Long = TimeUnit.MILLISECONDS.toMinutes(currentDate.time - callDate.time)

            val callType: CallType = when (type.toInt()) {
                CallLog.Calls.INCOMING_TYPE -> CallType.INCOMING
                CallLog.Calls.OUTGOING_TYPE -> CallType.OUTGOING
                else -> CallType.MISSED
            }

            items.add(
                PhoneCallLog(
                    number = number,
                    type = callType,
                    date = Date(date.toLong()).toString(),
                    duration = duration.toInt()
                )
            )
        }
        cursor.close()

        return items
    }
}