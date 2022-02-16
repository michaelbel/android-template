package org.michaelbel.template.features.compose.social

import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultRegistryOwner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
import com.google.android.gms.common.api.ApiException
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import org.michaelbel.core.ktx.checkPackageNameValid
import org.michaelbel.template.R
import org.michaelbel.template.ui.theme.AppTheme

/**
 * Google SignIn
 * VK Auth
 */

@Composable
fun SocialScreen(
    navController: NavController
) {
    val viewModel: SocialViewModel = hiltViewModel()

    Scaffold(
        topBar = { Toolbar(navController) }
    ) {
        Content(
            viewModel = viewModel
        )
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = { Text(text = stringResource(R.string.title_social)) },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        }
    )
}

@Composable
private fun Content(
    viewModel: SocialViewModel
) {
    val context: Context = LocalContext.current
    val owner: ActivityResultRegistryOwner = context as ActivityResultRegistryOwner

    val googleSignInContract = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            viewModel.onGoogleSignInSuccess(account)
        } catch (exception: ApiException) {
            if (exception.statusCode == GoogleSignInStatusCodes.SIGN_IN_CANCELLED) {
                viewModel.onGoogleSignInCancel()
            } else {
                viewModel.onGoogleSignInFailure(exception)
            }
        }
    }

    val vkAuthContract = rememberLauncherForActivityResult(
        VK.getVKAuthActivityResultContract()
    ) { result: VKAuthenticationResult ->
        when (result) {
            is VKAuthenticationResult.Success -> {
                viewModel.onVKAuthSuccess(result.token)
            }
            is VKAuthenticationResult.Failed -> {
                viewModel.onVKAuthFailure(result.exception)
            }
        }
    }

    LazyColumn {
        item {
            OutlinedButton(
                onClick = {
                    googleSignInContract.launch(viewModel.googleSignInClient.signInIntent)
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.sign_in_google)) }
        }
        item {
            OutlinedButton(
                onClick = {
                    context.checkPackageNameValid {
                        vkAuthContract.launch(arrayListOf(VKScope.EMAIL, VKScope.OFFLINE))
                    }
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.sign_in_vk)) }
        }
        item {
            OutlinedButton(
                onClick = {
                    viewModel.facebookLogin(owner)
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.sign_in_facebook)) }
        }
    }
}

@Preview
@Composable
private fun SocialPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    AppTheme {
        SocialScreen(
            navController = navController
        )
    }
}

@Preview
@Composable
private fun SocialPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    AppTheme(
        darkTheme = true
    ) {
        SocialScreen(
            navController = navController
        )
    }
}