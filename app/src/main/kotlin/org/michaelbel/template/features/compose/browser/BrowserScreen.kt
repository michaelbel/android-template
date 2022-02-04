package org.michaelbel.template.features.compose.browser

import android.content.Context
import android.content.Intent
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
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
import org.michaelbel.template.R
import org.michaelbel.template.ui.theme.AppTheme

/**
 * Browser & InAppBrowser samples.
 */

@Composable
fun BrowserScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { Toolbar(navController) }
    ) {
        Content()
    }
}

@Composable
private fun Toolbar(
    navController: NavController
) {
    SmallTopAppBar(
        title = { Text(text = stringResource(R.string.title_browser)) },
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
private fun Content() {
    val context: Context = LocalContext.current

    fun browserIntent(url: String): Intent {
        return Intent(Intent.ACTION_VIEW, url.toUri())
    }

    fun inAppBrowseIntent(url: String): Intent {
        val colorSchemeParams: CustomTabColorSchemeParams = CustomTabColorSchemeParams.Builder()
            .setToolbarColor(ContextCompat.getColor(context, R.color.Primary))
            .build()
        val customTabsIntentBuilder: CustomTabsIntent.Builder = CustomTabsIntent.Builder()
        customTabsIntentBuilder.setDefaultColorSchemeParams(colorSchemeParams)
        val customTabsIntent: CustomTabsIntent = customTabsIntentBuilder.build()
        customTabsIntent.intent.data = url.toUri()
        return customTabsIntent.intent
    }

    LazyColumn {
        item {
            OutlinedButton(
                onClick = { context.startActivity(browserIntent("https://www.google.com")) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.start_browser)) }
        }
        item {
            OutlinedButton(
                onClick = { context.startActivity(inAppBrowseIntent("https://www.google.com")) },
                modifier = Modifier
                    .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.start_in_app_browser)) }
        }
    }
}

@Preview
@Composable
private fun BrowserPreview() {
    val context: Context = LocalContext.current

    AppTheme {
        BrowserScreen(
            navController = NavController(context)
        )
    }
}

@Preview
@Composable
private fun BrowserPreviewDark() {
    val context: Context = LocalContext.current

    AppTheme(darkTheme = true) {
        BrowserScreen(
            navController = NavController(context)
        )
    }
}