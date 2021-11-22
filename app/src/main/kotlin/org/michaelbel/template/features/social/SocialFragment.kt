package org.michaelbel.template.features.social

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.exceptions.VKAuthException
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentSocialBinding

@AndroidEntryPoint
class SocialFragment: Fragment(R.layout.fragment_social) {

    @Inject lateinit var googleSignInClient: GoogleSignInClient

    private val viewModel: SocialViewModel by viewModels()
    private val binding: FragmentSocialBinding by viewBinding()

    private val googleSignInContract = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
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

    private val vkAuthCallback = object: VKAuthCallback {
        override fun onLogin(token: VKAccessToken) {
            vkAuthSuccess(token)
        }

        override fun onLoginFailed(authException: VKAuthException) {
            vkAuthFailure(authException)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.googleData.collect(::fetchGoogleData)
        }

        binding.googleCard.setOnClickListener {
            googleSignInContract.launch(googleSignInClient.signInIntent)
        }
        binding.vkCard.setOnClickListener {
            VK.login(requireActivity(), arrayListOf(VKScope.EMAIL, VKScope.OFFLINE))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!VK.onActivityResult(requestCode, resultCode, data, vkAuthCallback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun fetchGoogleData(googleData: SocialViewModel.GoogleData) {
        if (googleData.isNotEmpty) {
            binding.googleAvatarImageView.load(googleData.photoUrl)
            binding.googleTextView.text = googleData.displayName
        }
    }

    private fun googleAuthSuccess(account: GoogleSignInAccount) {
        viewModel.setGoogleAccount(account)
    }

    private fun googleAuthCancel() {
        Snackbar.make(binding.root, "Google Sign In Cancel", Snackbar.LENGTH_SHORT).show()
    }

    private fun googleAuthFailure(e: ApiException) {
        Snackbar.make(binding.root, "Google Sign In Failure $e", Snackbar.LENGTH_SHORT).show()
    }

    private fun vkAuthSuccess(token: VKAccessToken) {
        binding.vkTextView.text = token.userId.toString()
    }

    private fun vkAuthFailure(authException: VKAuthException) {
        Snackbar.make(binding.root, "VK Auth Failure $authException", Snackbar.LENGTH_SHORT).show()
    }
}