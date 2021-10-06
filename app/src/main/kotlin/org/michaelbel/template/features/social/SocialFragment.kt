package org.michaelbel.template.features.social

import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
import com.google.android.gms.common.api.ApiException
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentSocialBinding
import javax.inject.Inject

@AndroidEntryPoint
class SocialFragment: Fragment(R.layout.fragment_social) {

    @Inject lateinit var analytics: Analytics
    @Inject lateinit var googleSignInClient: GoogleSignInClient

    private val binding: FragmentSocialBinding by viewBinding()

    private val googleSignInContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result?.data)
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            googleAuthSuccess(account)
        } catch (e: ApiException) {
            if (e.statusCode == GoogleSignInStatusCodes.SIGN_IN_CANCELLED) {
                googleAuthCancel()
            } else {
                googleAuthFailure(e)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(SocialFragment::class.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.googleTextView.setOnClickListener {
            googleSignInContract.launch(googleSignInClient.signInIntent)
        }
    }

    private fun googleAuthSuccess(account: GoogleSignInAccount) {
        binding.googleTextView.text = account.displayName
    }

    private fun googleAuthCancel() {
        binding.googleTextView.text = "SignIn Cancelled"
    }

    private fun googleAuthFailure(e: ApiException) {
        binding.googleTextView.text = "SignIn Failure $e"
    }
}