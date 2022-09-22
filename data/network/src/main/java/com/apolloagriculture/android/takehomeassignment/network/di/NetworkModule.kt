package com.apolloagriculture.android.takehomeassignment.network.di

import android.util.Log
import com.apolloagriculture.android.takehomeassignment.network.BuildConfig
import com.apolloagriculture.android.takehomeassignment.network.ForecastApiService
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.http.URLProtocol
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    /**
     * Creates a http client for Ktor that is provided to the
     * API client via constructor injection
     */
    single {
        HttpClient(Android) {
            defaultRequest {
                url {
                    host = ForecastApiService.BASE_URL
                    url { protocol = URLProtocol.HTTPS }
                }
            }

            if (BuildConfig.DEBUG) {
                install(Logging) {
                    level = LogLevel.HEADERS
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.e("Http Client", message)
                        }
                    }
                }
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
        }
    }

    single { ForecastApiService(httpClient = get()) }
}