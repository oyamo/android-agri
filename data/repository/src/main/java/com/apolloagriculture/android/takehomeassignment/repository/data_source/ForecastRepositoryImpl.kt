package com.apolloagriculture.android.takehomeassignment.repository.data_source

import com.apolloagriculture.android.takehomeassignment.cache.AppDatabase
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import com.apolloagriculture.android.takehomeassignment.domain.utils.Result
import com.apolloagriculture.android.takehomeassignment.network.ForecastApiService
import com.apolloagriculture.android.takehomeassignment.network.utils.safeApiCall
import com.apolloagriculture.android.takehomeassignment.repository.mappers.toDomain
import com.apolloagriculture.android.takehomeassignment.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class ForecastRepositoryImpl constructor(
    private val forecastApiService: ForecastApiService,
    private val appDatabase: AppDatabase
) : ForecastRepository {

    override suspend fun getForecast(): Flow<List<Forecast>> {
        val cachedForecast = appDatabase.forecastDao().getForecast()
            .map { it.map { forecastEntity -> forecastEntity.toDomain() } }
            .onEach { foreCast ->
                if (foreCast.isEmpty()) fetchForecast()
            }

        return cachedForecast
    }

    @Throws(Exception::class)
    override suspend fun fetchForecast() {

        when (val networkForecast = safeApiCall { forecastApiService.fetchForecast() }) {
            is Result.Error -> throw Exception(networkForecast.error)
            is Result.Success -> {
                networkForecast.data?.mapValues { it.value.toEntity(key = it.key) }?.values?.toList()
                    .also {
                        it?.let { forecasts -> appDatabase.forecastDao().saveForecast(forecasts) }
                    }
            }
        }
    }

}