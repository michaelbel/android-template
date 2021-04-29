package org.michaelbel.template

import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.movie.ui.MovieFragment
import java.lang.ref.WeakReference

@AndroidEntryPoint
class MainActivity: AppCompatActivity(R.layout.activity_main) {

    private var telephonyManager: TelephonyManager? = null
    private var phoneStateListener: PhoneListener? = null

    override fun onStart() {
        super.onStart()
        telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        phoneStateListener = PhoneListener(this)
        telephonyManager?.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.container, MovieFragment.newInstance())
            }
        }
    }

    override fun onStop() {
        super.onStop()
        telephonyManager?.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE)
        phoneStateListener = null
    }

    private class PhoneListener(activity: MainActivity): PhoneStateListener() {

        private var isPlaying: Boolean = false
        private val weakActivity: WeakReference<MainActivity> = WeakReference(activity)

        override fun onCallStateChanged(state: Int, phoneNumber: String?) {
            val activity: MainActivity? = weakActivity.get()
            when (state) {
                TelephonyManager.CALL_STATE_OFFHOOK, TelephonyManager.CALL_STATE_RINGING -> {
                    if (activity != null) {
                        //activity.stopPlayback()
                        isPlaying = true
                    }
                }
                TelephonyManager.CALL_STATE_IDLE -> {
                    if (activity != null && isPlaying) {
                        //activity.startPlayback()
                    }
                }
            }
        }
    }
}