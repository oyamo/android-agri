package com.apolloagriculture.android.takehomeassignment.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apolloagriculture.android.takehomeassignment.ui.components.ForecastCard
import com.apolloagriculture.android.takehomeassignment.ui.theme.ApolloAndroidTheme
import com.apolloagriculture.android.takehomeassignment.utils.UiState
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 2.dp),
    viewModel: HomeViewModel = getViewModel()
) {

    when (val forecastUiState = viewModel.forecastUiState.collectAsState().value) {

        /**Display loading state*/
        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colors.primary
                )
            }
        }

        /**Display success state*/
        is UiState.Success -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .testTag("forecast_lazy_column"),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                forecastUiState.data?.let { forecast ->
                    items(items = forecast) {
                        ForecastCard(modifier = Modifier.fillMaxWidth(), forecast = it)
                    }
                }

            }
        }

        /**Display error state*/
        is UiState.Error -> {

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