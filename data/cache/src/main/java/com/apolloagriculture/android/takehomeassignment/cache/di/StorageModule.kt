package com.apolloagriculture.android.takehomeassignment.cache.di

import androidx.room.Room
import com.apolloagriculture.android.takehomeassignment.cache.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val cacheModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "ApolloAgriculture.db"
        ).fallbackToDestructiveMigration().build()
    }
}
