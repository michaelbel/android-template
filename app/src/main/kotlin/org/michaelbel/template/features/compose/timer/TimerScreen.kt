package org.michaelbel.template.features.compose.timer

import android.content.Context
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import org.michaelbel.template.R
import org.michaelbel.template.ui.theme.AppTheme

/**
 * Coroutines Timer
 */

@Composable
fun TimerScreen(
    navController: NavController
) {
    val viewModel: TimerViewModel = hiltViewModel()

    Scaffold(
        topBar = {
            Toolbar(navController)
        }
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
        title = { Text(text = stringResource(R.string.title_timer)) },
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
    viewModel: TimerViewModel
) {
    val context: Context = LocalContext.current

    val isTimeOver: Boolean by rememberUpdatedState(viewModel.isTimeOver)

    if (isTimeOver) {
        Toast.makeText(context, R.string.time_over, Toast.LENGTH_SHORT).show()
    }

    LazyColumn {
        item {
            OutlinedButton(
                onClick = {
                    viewModel.startTimer()
                },
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 4.dp)
            ) { Text(text = stringResource(R.string.start_timer)) }
        }
    }
}

@Preview
@Composable
private fun TimerPreview() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    AppTheme {
        TimerScreen(
            navController = navController
        )
    }
}

@Preview
@Composable
private fun TimerPreviewDark() {
    val context: Context = LocalContext.current
    val navController = NavController(context)

    AppTheme(
        darkTheme = true
    ) {
        TimerScreen(
            navController = navController
        )
    }
}