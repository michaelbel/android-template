package org.michaelbel.template.features.compose.social

import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.exceptions.VKAuthException
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics

@HiltViewModel
class SocialViewModel @Inject constructor(
    val googleSignInClient: GoogleSignInClient
): ViewModel() {

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen("SocialScreen")
    }

    fun onGoogleSignInSuccess(account: GoogleSignInAccount) {}

    fun onGoogleSignInCancel() {}

    fun onGoogleSignInFailure(exception: ApiException) {}

    fun onVKAuthSuccess(token: VKAccessToken) {}

    fun onVKAuthFailure(exception: VKAuthException) {}
}