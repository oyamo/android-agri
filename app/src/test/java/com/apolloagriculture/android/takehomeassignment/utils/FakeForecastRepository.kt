package com.apolloagriculture.android.takehomeassignment.utils

import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeForecastRepository : ForecastRepository {

    private val foreCast = Forecast(
        day = "today",
        lowTemp = 10.45f,
        highTemp = 12.34f,
        icon = "CLEAR_DAY",
        description = "clear sky"
    )

    private val foreCasts = listOf(foreCast)

    override suspend fun getForecast(): Flow<List<Forecast>> {
        return flowOf(foreCasts)
    }

    override suspend fun fetchForecast() {
        TODO("Not yet implemented")
    }
}