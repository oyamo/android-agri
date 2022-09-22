package com.apolloagriculture.android.takehomeassignment.domain.repository

import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast

interface ForecastRepository {

    suspend fun fetchForecast(): List<Forecast>

}