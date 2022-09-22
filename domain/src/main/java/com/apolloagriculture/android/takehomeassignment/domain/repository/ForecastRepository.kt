package com.apolloagriculture.android.takehomeassignment.domain.repository

import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import kotlinx.coroutines.flow.Flow

interface ForecastRepository {

    suspend fun getForecast(): Flow<List<Forecast>>

    suspend fun fetchForecast()

}