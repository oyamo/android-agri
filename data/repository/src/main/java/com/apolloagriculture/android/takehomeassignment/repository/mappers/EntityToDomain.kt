package com.apolloagriculture.android.takehomeassignment.repository.mappers

import com.apolloagriculture.android.takehomeassignment.cache.models.ForecastEntity
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast

internal fun ForecastEntity.toDomain(): Forecast {
    return Forecast(
        day = this.day,
        lowTemp = this.lowTemp,
        highTemp = this.highTemp,
        icon = this.icon,
        description = this.description
    )
}
