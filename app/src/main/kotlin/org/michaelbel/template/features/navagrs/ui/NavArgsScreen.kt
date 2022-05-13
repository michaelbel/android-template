package org.michaelbel.template.features.navagrs.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R
import org.michaelbel.template.features.navagrs.NavArgsFragmentArgs
import org.michaelbel.template.ui.OnNavigationBackClick

@Composable
fun NavArgsScreen(
    args: NavArgsFragmentArgs,
    onNavigationBackClick: OnNavigationBackClick
) {
    Scaffold(
        topBar = { Toolbar(onNavigationBackClick) }
    ) { Content(args) }
}

@Composable
private fun Toolbar(onNavigationBackClick: OnNavigationBackClick) {
    SmallTopAppBar(
        title = { Text(text = stringResource(R.string.title_nav_args)) },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            IconButton(onClick = { onNavigationBackClick() }) {
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
    args: NavArgsFragmentArgs
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Arguments: ${args.firstText}, ${args.secondNumber}",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(name = "default", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ClipboardScreenPreview() {
    /*NavArgsScreen(
        onNavigationBackClick = {}
    )*/
}