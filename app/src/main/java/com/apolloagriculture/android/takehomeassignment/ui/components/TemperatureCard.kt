package com.apolloagriculture.android.takehomeassignment.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TemperatureCard(modifier: Modifier = Modifier, title: String, temperature: Float) {

    Card(modifier = modifier, shape = MaterialTheme.shapes.small) {

        Column(
            modifier = modifier.padding(vertical = 4.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Text(
                text = title.uppercase(),
                fontSize = 22.sp,
                style = MaterialTheme.typography.h4,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface
            )

            Text(
                text = temperature.toString(),
                fontSize = 16.sp,
                style = MaterialTheme.typography.h5,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface
            )

        }
    }

}

@Composable
@Preview
fun Previews() {
    TemperatureCard(title = "High", temperature = 34.45f)
}
