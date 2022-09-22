package com.apolloagriculture.android.takehomeassignment.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Forecast Table")
data class ForecastEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,

    @ColumnInfo(name = "day")
    val day: String,

    @ColumnInfo(name = "lowTemp")
    val lowTemp: Float,

    @ColumnInfo(name = "highTemp")
    val highTemp: Float,

    @ColumnInfo(name = "icon")
    val icon: String,

    @ColumnInfo(name = "description")
    val description: String
)
