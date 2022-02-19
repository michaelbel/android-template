package org.michaelbel.template.features.compose.intents

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R

/**
 * Settings Panel Intents (Connectivity, NFC, Volume, Wi-Fi)
 * Share Intent
 * Email Intent
 * GooglePlay Intent
 * Telegram Intent
 * Google Voice Input
 * Browser
 * InApp Browser
 *
 * Settings.Global.getString(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON)
 * 0 if false, 1 if true.
 */

@RequiresApi(29)
@Composable
fun IntentsScreen(
    navController: NavController
) {
    val context: Context = LocalContext.current

    val speechRecognizeContract = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        val data: Intent? = activityResult.data
        val spokenText: String? =
            data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.let { results ->
                results[0]
            }
        Toast.makeText(context, spokenText, Toast.LENGTH_SHORT).show()
    }

    val resultContract = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {}

    Scaffold(
        topBar = {
            Toolbar(navController)
        }
    ) {
        Content(
            resultContract,
            speechRecognizeContract
        )
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = {
            Text(text = stringResource(R.string.title_intents))
        },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_back)
                )
            }
        }
    )
}

@RequiresApi(29)
@Composable
private fun Content(
    resultContract: ManagedActivityResultLauncher<Intent, ActivityResult>,
    speechRecognizeContract: ManagedActivityResultLauncher<Intent, ActivityResult>
) {
    val context: Context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            Text(
                text = "Settings Panel",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            )
        }
        item {
            OutlinedButton(
                onClick = {
                    resultContract.launch(Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY))
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.settings_panel_connectivity)) }
        }
        item {
            OutlinedButton(
                onClick = { resultContract.launch(Intent(Settings.Panel.ACTION_NFC)) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.settings_panel_nfc)) }
        }
        item {
            OutlinedButton(
                onClick = { resultContract.launch(Intent(Settings.Panel.ACTION_VOLUME)) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.settings_panel_volume)) }
        }
        item {
            OutlinedButton(
                onClick = { resultContract.launch(Intent(Settings.Panel.ACTION_WIFI)) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
            ) { Text(text = stringResource(R.string.settings_panel_wifi)) }
        }
        item {
            Text(
                text = "Actions",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            )
        }
        item {
            OutlinedButton(
                onClick = {
                    val shareLink = "https://google.com"
                    val shareIntent = Intent().apply {
                        type = "text/plain"
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, shareLink)
                    }
                    resultContract.launch(
                        Intent.createChooser(shareIntent, context.getString(R.string.share_via))
                    )
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
            ) { Text(text = stringResource(R.string.share_intent)) }
        }
        item {
            OutlinedButton(
                onClick = {
                    val email = "michaelbel24865@gmail.com"
                    val emailSubject = "Email Title"
                    val emailText = "Email Body"
                    val emailIntent = Intent(
                        Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", email, null)
                    ).apply {
                        putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                        putExtra(Intent.EXTRA_TEXT, emailText)
                    }
                    resultContract.launch(
                        Intent.createChooser(emailIntent, context.getString(R.string.email_via))
                    )
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
            ) { Text(text = stringResource(R.string.email_intent)) }
        }
        item {
            OutlinedButton(
                onClick = {
                    val appMarketLink = "market://details?id=${context.packageName}"
                    val appBrowserLink =
                        "https://play.google.com/store/apps/details?id=${context.packageName}"
                    try {
                        val googlePlayIntent = Intent(
                            Intent.ACTION_VIEW,
                            appMarketLink.toUri()
                        )
                        resultContract.launch(googlePlayIntent)
                    } catch (e: ActivityNotFoundException) {
                        val googlePlayIntent = Intent(
                            Intent.ACTION_VIEW,
                            appBrowserLink.toUri()
                        )
                        resultContract.launch(googlePlayIntent)
                    }
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
            ) { Text(text = stringResource(R.string.google_play)) }
        }
        item {
            OutlinedButton(
                onClick = {
                    val telegramChat = "https://t.me/michaelbel"
                    val telegramIntent = Intent(
                        Intent.ACTION_VIEW,
                        telegramChat.toUri()
                    )
                    resultContract.launch(telegramIntent)
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
            ) { Text(text = stringResource(R.string.open_telegram_chat)) }
        }
        item {
            OutlinedButton(
                onClick = {
                    val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                        putExtra(
                            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                        )
                    }
                    speechRecognizeContract.launch(intent)
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
            ) { Text(text = stringResource(R.string.voice_input)) }
        }
        item {
            Text(
                text = "Browser",
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            )
        }
        item {
            OutlinedButton(
                onClick = {
                    val url = "https://www.google.com"
                    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                    resultContract.launch(intent)
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.start_browser)) }
        }
        item {
            OutlinedButton(
                onClick = {
                    val url = "https://www.google.com"
                    val colorSchemeParams: CustomTabColorSchemeParams = CustomTabColorSchemeParams.Builder()
                        .setToolbarColor(ContextCompat.getColor(context, R.color.Primary))
                        .build()
                    val customTabsIntentBuilder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
                    customTabsIntentBuilder.setDefaultColorSchemeParams(colorSchemeParams)
                    val customTabsIntent: CustomTabsIntent = customTabsIntentBuilder.build()
                    customTabsIntent.intent.data = url.toUri()
                    resultContract.launch(customTabsIntent.intent)
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.start_in_app_browser)) }
        }
    }
}