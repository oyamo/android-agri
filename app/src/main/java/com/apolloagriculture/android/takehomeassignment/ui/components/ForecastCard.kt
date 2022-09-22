package com.apolloagriculture.android.takehomeassignment.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apolloagriculture.android.takehomeassignment.R
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast

@Composable
fun ForecastCard(modifier: Modifier = Modifier, forecast: Forecast) {

    Card(modifier = modifier, shape = MaterialTheme.shapes.medium) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = forecast.day.uppercase(),
                fontSize = 22.sp,
                style = MaterialTheme.typography.h5,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface
            )

            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = forecast.description
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TemperatureCard(title = "High", temperature = forecast.highTemp)

                TemperatureCard(title = "Low", temperature = forecast.lowTemp)
            }
        }
    }

}

@Composable
@Preview
fun Preview() {

    ForecastCard(
        modifier = Modifier.fillMaxWidth(),
        forecast = Forecast(
            day = "Today",
            lowTemp = 10.43f,
            highTemp = 14.56f,
            icon = "icon",
            description = "description"
        )
    )

}