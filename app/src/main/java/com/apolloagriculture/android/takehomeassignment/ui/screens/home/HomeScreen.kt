package com.apolloagriculture.android.takehomeassignment.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apolloagriculture.android.takehomeassignment.ui.components.ForecastCard
import com.apolloagriculture.android.takehomeassignment.ui.theme.ApolloAndroidTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    viewModel: HomeViewModel = getViewModel()
) {

    val forecast = viewModel.forecast.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        forecast?.let {
            items(items = forecast) {
                ForecastCard(
                    modifier = Modifier.fillMaxWidth(),
                    forecast = it
                )
            }
        }

    }

}

@Preview()
@Composable
fun Preview() {
    ApolloAndroidTheme {
        HomeScreen()
    }
}