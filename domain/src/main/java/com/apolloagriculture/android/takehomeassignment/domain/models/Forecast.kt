package com.apolloagriculture.android.takehomeassignment.domain.models

data class Forecast(
    val day: String,
    val lowTemp: Float,
    val highTemp: Float,
    val icon: String,
    val description: String
)
