package com.apolloagriculture.android.takehomeassignment.repository.di

import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ForecastRepository> { ForecastRepositoryImpl(forecastApiService = get()) }
}