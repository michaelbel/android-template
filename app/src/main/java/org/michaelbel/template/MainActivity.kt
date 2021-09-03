package org.michaelbel.template

import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference

@AndroidEntryPoint
class MainActivity: AppCompatActivity(R.layout.activity_main) {

    private var telephonyManager: TelephonyManager? = null
    private var phoneStateListener: PhoneListener? = null

    private val onExitAnimationListener = object: SplashScreen.OnExitAnimationListener {
        override fun onSplashScreenExit(splashScreenViewProvider: SplashScreenViewProvider) {}
    }

    override fun onStart() {
        super.onStart()
        telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        phoneStateListener = PhoneListener(this)
        telephonyManager?.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE)
    }

    override fun onStop() {
        super.onStop()
        telephonyManager?.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE)
        phoneStateListener = null
    }

    /*override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val splashScreen: SplashScreen = installSplashScreen()
        splashScreen.setOnExitAnimationListener(onExitAnimationListener)
        setContentView(R.layout.activity_main)
    }*/

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