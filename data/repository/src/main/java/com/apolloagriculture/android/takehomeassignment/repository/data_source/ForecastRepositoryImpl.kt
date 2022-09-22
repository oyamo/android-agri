package com.apolloagriculture.android.takehomeassignment.repository.data_source

import com.apolloagriculture.android.takehomeassignment.cache.AppDatabase
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import com.apolloagriculture.android.takehomeassignment.network.ForecastApiService
import com.apolloagriculture.android.takehomeassignment.repository.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class ForecastRepositoryImpl constructor(
    private val forecastApiService: ForecastApiService,
    private val appDatabase: AppDatabase
) : ForecastRepository {

    override suspend fun getForecast(): Flow<List<Forecast>> {
        val result = appDatabase.forecastDao().getForecast()
            .map { it.map { forecastEntity -> forecastEntity.toDomain() } }
            .onEach { foreCast ->
                if (foreCast.isEmpty()) fetchForecast()
            }

        return result
    }

    override suspend fun fetchForecast() {
        val response = forecastApiService.fetchForecast()

        response.mapValues { it.value.toDomain(key = it.key) }.values.toList().also {
            appDatabase.forecastDao().saveForecast(it)
        }
    }

}