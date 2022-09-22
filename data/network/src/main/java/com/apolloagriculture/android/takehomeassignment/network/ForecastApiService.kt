package com.apolloagriculture.android.takehomeassignment.network

import com.apolloagriculture.android.takehomeassignment.network.models.ForecastDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ForecastApiService constructor(private val httpClient: HttpClient) {

    suspend fun fetchForecast(): HashMap<String, ForecastDto> {
        return httpClient.get(urlString = FORECAST_URL)
    }

    companion object {
        const val BASE_URL = "s3.eu-west-1.amazonaws.com/assets.apolloagriculture.com"
        const val FORECAST_URL = "recruitment/android/weather.json"
    }

}