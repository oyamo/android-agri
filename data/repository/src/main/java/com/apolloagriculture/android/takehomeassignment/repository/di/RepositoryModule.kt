package com.apolloagriculture.android.takehomeassignment.repository.di

import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import com.apolloagriculture.android.takehomeassignment.repository.data_source.ForecastRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<ForecastRepository> {
        ForecastRepositoryImpl(
            forecastApiService = get(),
            appDatabase = get()
        )
    }
}