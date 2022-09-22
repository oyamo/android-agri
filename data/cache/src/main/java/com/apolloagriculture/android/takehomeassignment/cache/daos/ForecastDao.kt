package com.apolloagriculture.android.takehomeassignment.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apolloagriculture.android.takehomeassignment.cache.models.ForecastEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveForecast(forecast: List<ForecastEntity>)

    @Query("SELECT * FROM `Forecast Table`")
    fun getForecast(): Flow<List<ForecastEntity>>

}