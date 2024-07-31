package org.michaelbel.template.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.michaelbel.template.ui.TemplateTheme

@Composable
fun ContextualScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

    }
}

@Preview
@Composable
private fun ContextualScreenPreview() {
    TemplateTheme {
        ContextualScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}