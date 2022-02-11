package org.michaelbel.template.features.compose.social

import android.util.Log
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.lifecycle.ViewModel
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.exceptions.VKAuthException
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics

@HiltViewModel
class SocialViewModel @Inject constructor(
    val googleSignInClient: GoogleSignInClient
): ViewModel() {

    private val facebookCallbackManager
        get() = CallbackManager.Factory.create()

    private val facebookLoginManager
        get() = LoginManager.getInstance()

    private val facebookCallback = object: FacebookCallback<LoginResult> {
        override fun onCancel() {
            onFacebookCancel()
        }

        override fun onError(error: FacebookException) {
            onFacebookFailure(error)
        }

        override fun onSuccess(result: LoginResult) {
            onFacebookSuccess(result)
        }
    }

    fun facebookLogin(owner: ActivityResultRegistryOwner) {
        facebookLoginManager.logIn(
            owner,
            facebookCallbackManager,
            listOf("public_profile", "email")
        )
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen("SocialScreen")
    }

    fun onGoogleSignInSuccess(account: GoogleSignInAccount) {}

    fun onGoogleSignInCancel() {}

    fun onGoogleSignInFailure(exception: ApiException) {}

    fun onVKAuthSuccess(token: VKAccessToken) {}

    fun onVKAuthFailure(exception: VKAuthException) {}

    fun onFacebookSuccess(result: LoginResult) {
        Log.e("2580", "onFacebookSuccess $result")
    }

    fun onFacebookCancel() {
        Log.e("2580", "onFacebookCancel")
    }

    fun onFacebookFailure(error: FacebookException) {
        Log.e("2580", "onFacebookFailure $error")
    }

    private fun googleLogout() {
        googleSignInClient.signOut()
    }

    private fun vkLogout() {
        VK.logout()
    }

    private fun facebookLogout() {
        facebookLoginManager.logOut()
    }
}