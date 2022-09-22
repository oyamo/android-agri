package com.apolloagriculture.android.takehomeassignment.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apolloagriculture.android.takehomeassignment.cache.daos.ForecastDao
import com.apolloagriculture.android.takehomeassignment.cache.models.ForecastEntity

@Database(
    entities = [ForecastEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao
}
