package org.michaelbel.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity(R.layout.activity_main) {

    private val onExitAnimationListener = object: SplashScreen.OnExitAnimationListener {
        override fun onSplashScreenExit(splashScreenViewProvider: SplashScreenViewProvider) {}
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        //val splashScreen: SplashScreen = installSplashScreen()
        //splashScreen.setOnExitAnimationListener(onExitAnimationListener)
    }
}