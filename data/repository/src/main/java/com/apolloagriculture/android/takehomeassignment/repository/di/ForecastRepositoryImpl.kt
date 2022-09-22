package com.apolloagriculture.android.takehomeassignment.repository.di

import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import com.apolloagriculture.android.takehomeassignment.network.ForecastApiService
import com.apolloagriculture.android.takehomeassignment.repository.mappers.toDomain

class ForecastRepositoryImpl constructor(private val forecastApiService: ForecastApiService) :
    ForecastRepository {

    override suspend fun fetchForecast(): Map<String, Forecast> {
        return forecastApiService.fetchForecast().mapValues { it.value.toDomain() }
    }

}