package com.apolloagriculture.android.takehomeassignment

import android.app.Application
import com.apolloagriculture.android.takehomeassignment.cache.di.cacheModule
import com.apolloagriculture.android.takehomeassignment.di.presentationModule
import com.apolloagriculture.android.takehomeassignment.network.di.networkModule
import com.apolloagriculture.android.takehomeassignment.repository.di.repositoryModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class ApolloAndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(networkModule, repositoryModule, presentationModule, cacheModule)

        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@ApolloAndroidApplication)
            modules(modules)
        }

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}