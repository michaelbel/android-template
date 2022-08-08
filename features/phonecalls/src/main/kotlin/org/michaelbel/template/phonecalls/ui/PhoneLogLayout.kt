package org.michaelbel.template.phonecalls.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.michaelbel.template.phonecalls.model.CallType
import org.michaelbel.template.phonecalls.model.PhoneCallLog

@Composable
fun PhoneLogLayout(
    log: PhoneCallLog
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
    ) {
        Text(
            text = "Number: ${log.number}"
        )
        Text(
            text = "Type: ${log.type.text}"
        )
        Text(
            text = "Date: ${log.date}"
        )
        Text(
            text = "Duration: ${log.duration} sec"
        )
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    val phoneLog = PhoneCallLog(
        number = "+78005553535",
        type = CallType.INCOMING,
        date = "Fri Aug 05 21:22:37 GMT+03:00 2022",
        duration = 112
    )

    PhoneLogLayout(
        phoneLog
    )
}