package com.apolloagriculture.android.takehomeassignment.repository.di

import android.util.Log
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import com.apolloagriculture.android.takehomeassignment.network.ForecastApiService
import com.apolloagriculture.android.takehomeassignment.repository.mappers.toDomain

class ForecastRepositoryImpl constructor(private val forecastApiService: ForecastApiService) :
    ForecastRepository {

    override suspend fun fetchForecast(): List<Forecast> {
        val response = forecastApiService.fetchForecast()
        Log.e("TAG", "Response: $response")
        Log.e("TAG", "Response entries: ${response.values}")

        return response.values.map { it.toDomain() }
    }

}