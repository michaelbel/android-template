package org.michaelbel.template.app

import android.content.Context
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GoogleApi @Inject constructor(
    @ApplicationContext private val context: Context,
    private val googleApiAvailability: GoogleApiAvailability
) {

    val isPlayServicesAvailable: Boolean
        get() {
            val status = googleApiAvailability.isGooglePlayServicesAvailable(context)
            return status == ConnectionResult.SUCCESS
        }
}