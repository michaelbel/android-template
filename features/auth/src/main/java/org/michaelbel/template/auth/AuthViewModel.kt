package org.michaelbel.template.auth

import android.content.Intent
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
class AuthViewModel @Inject constructor(
    private val googleSignInClient: GoogleSignInClient
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

    val googleIntent: Intent
        get() = googleSignInClient.signInIntent

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

    fun onGoogleSignInSuccess(account: GoogleSignInAccount) {
        /* not implemented */
    }

    fun onGoogleSignInCancel() {
        /* not implemented */
    }

    fun onGoogleSignInFailure(exception: ApiException) {
        /* not implemented */
    }

    fun onVKAuthSuccess(token: VKAccessToken) {
        /* not implemented */
    }

    fun onVKAuthFailure(exception: VKAuthException) {
        /* not implemented */
    }

    fun onFacebookSuccess(result: LoginResult) {
        /* not implemented */
    }

    fun onFacebookCancel() {
        /* not implemented */
    }

    fun onFacebookFailure(error: FacebookException) {
        /* not implemented */
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