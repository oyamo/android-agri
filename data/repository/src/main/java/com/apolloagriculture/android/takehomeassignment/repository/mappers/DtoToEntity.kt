package com.apolloagriculture.android.takehomeassignment.repository.mappers

import com.apolloagriculture.android.takehomeassignment.cache.models.ForecastEntity
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.network.models.ForecastDto

internal fun ForecastDto.toEntity(key: String): ForecastEntity {
    return ForecastEntity(
        day = key,
        lowTemp = this.lowTemp,
        highTemp = this.highTemp,
        icon = this.icon,
        description = this.description
    )
}