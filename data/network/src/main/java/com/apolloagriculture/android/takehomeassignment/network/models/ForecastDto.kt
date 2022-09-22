package com.apolloagriculture.android.takehomeassignment.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastDto(
    @SerialName("lowTemp")
    val lowTemp: Float,

    @SerialName("highTemp")
    val highTemp: Float,

    @SerialName("icon")
    val icon: String,

    @SerialName("description")
    val description: String
)
