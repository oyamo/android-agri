package com.apolloagriculture.android.takehomeassignment.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apolloagriculture.android.takehomeassignment.ui.theme.ApolloAndroidTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    viewModel: HomeViewModel = getViewModel()
) {

    val forecast = viewModel.forecast.collectAsState().value

    Text(text = "Forecast: \n $forecast")

}

@Preview()
@Composable
fun Preview() {
    ApolloAndroidTheme {
        HomeScreen()
    }
}