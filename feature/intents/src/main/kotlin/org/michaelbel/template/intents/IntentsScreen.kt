package org.michaelbel.template.intents

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.core.ktx.granted

/**
 * Settings Panel Intents (Connectivity, NFC, Volume, Wi-Fi)
 * Share Intent
 * Email Intent
 * Phone Intent
 * GooglePlay Intent
 * Telegram Intent
 * Google Voice Input
 * Browser
 * In-App Browser
 * App Settings Intent
 */

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
            Text(
                text = stringResource(R.string.title_intents)
            )
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
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
private fun Content(
    resultContract: ManagedActivityResultLauncher<Intent, ActivityResult>,
    speechRecognizeContract: ManagedActivityResultLauncher<Intent, ActivityResult>
) {
    val context: Context = LocalContext.current
    val packageName: String = context.packageName

    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            Text(
                text = stringResource(R.string.settings_panel),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            )
        }
        item {
            OutlinedButton(
                onClick = {
                    if (Build.VERSION.SDK_INT >= 29) {
                        resultContract.launch(Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY))
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.settings_panel_connectivity)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    if (Build.VERSION.SDK_INT >= 29) {
                        resultContract.launch(Intent(Settings.Panel.ACTION_NFC))
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.settings_panel_nfc)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    if (Build.VERSION.SDK_INT >= 29) {
                        resultContract.launch(Intent(Settings.Panel.ACTION_VOLUME))
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.settings_panel_volume)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    if (Build.VERSION.SDK_INT >= 29) {
                        resultContract.launch(Intent(Settings.Panel.ACTION_WIFI))
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.settings_panel_wifi)
                )
            }
        }
        item {
            Text(
                text = stringResource(R.string.actions),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            )
        }
        item {
            OutlinedButton(
                onClick = {
                    Intent().apply {
                        type = "text/plain"
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "https://google.com")
                    }.also { intent: Intent ->
                        Intent.createChooser(intent, context.getString(R.string.share_via))
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.share_intent)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    if (Manifest.permission.CALL_PHONE.granted(context)) {
                        Intent(
                            Intent.ACTION_CALL,
                            Uri.fromParts("tel", "88005553535", null)
                        ).also { intent: Intent ->
                            resultContract.launch(intent)
                        }
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.phone_intent)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    Intent(
                        Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", "michaelbel24865@gmail.com", null)
                    ).apply {
                        putExtra(Intent.EXTRA_SUBJECT, "Email Title")
                        putExtra(Intent.EXTRA_TEXT, "Email Body")
                    }.also { intent: Intent ->
                        Intent.createChooser(intent, context.getString(R.string.email_via))
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.email_intent)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    try {
                        Intent(
                            Intent.ACTION_VIEW,
                            "market://details?id=$packageName".toUri()
                        ).also { intent: Intent ->
                            resultContract.launch(intent)
                        }
                    } catch (e: ActivityNotFoundException) {
                        Intent(
                            Intent.ACTION_VIEW,
                            "https://play.google.com/store/apps/details?id=$packageName".toUri()
                        ).also { intent: Intent ->
                            resultContract.launch(intent)
                        }
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.google_play)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    Intent(
                        Intent.ACTION_VIEW,
                        "https://t.me/michaelbel".toUri()
                    ).also { intent: Intent ->
                        resultContract.launch(intent)
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.open_telegram_chat)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH
                    ).apply {
                        putExtra(
                            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                        )
                    }.also { intent: Intent ->
                        speechRecognizeContract.launch(intent)
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.voice_input)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        "package:$packageName".toUri()
                    ).apply {
                        addCategory(Intent.CATEGORY_DEFAULT)
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }.also { intent: Intent ->
                        resultContract.launch(intent)
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.app_settings)
                )
            }
        }
        item {
            Text(
                text = stringResource(R.string.browser),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            )
        }
        item {
            OutlinedButton(
                onClick = {
                    Intent(
                        Intent.ACTION_VIEW,
                        "https://www.google.com".toUri()
                    ).also { intent: Intent ->
                        resultContract.launch(intent)
                    }
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.start_browser)
                )
            }
        }
        item {
            OutlinedButton(
                onClick = {
                    val colorSchemeParams: CustomTabColorSchemeParams = CustomTabColorSchemeParams.Builder()
                        .setToolbarColor(ContextCompat.getColor(context, org.michaelbel.core.R.color.Primary))
                        .build()
                    val customTabsIntentBuilder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
                    customTabsIntentBuilder.setDefaultColorSchemeParams(colorSchemeParams)
                    val customTabsIntent: CustomTabsIntent = customTabsIntentBuilder.build()
                    customTabsIntent.intent.data = "https://www.google.com".toUri()
                    resultContract.launch(customTabsIntent.intent)
                },
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 4.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.start_in_app_browser)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    IntentsScreen(
        navController = navController
    )
}

@Preview
@Composable
private fun ScreenPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    IntentsScreen(
        navController = navController
    )
}