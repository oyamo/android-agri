package com.apolloagriculture.android.takehomeassignment.repository.mappers

import com.apolloagriculture.android.takehomeassignment.cache.models.ForecastEntity
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class EntityToDomainTest {

    private val forecastEntity =
        ForecastEntity(
            day = "day",
            lowTemp = 10f,
            highTemp = 10f,
            icon = "icon",
            description = "description"
        )

    private val forecast =
        Forecast(
            day = "day",
            lowTemp = 10f,
            highTemp = 10f,
            icon = "icon",
            description = "description"
        )

    @Test
    fun `forecastEntity is correctly mapped to forecast domain model`() {
        val result = forecastEntity.toDomain()

        assertThat(result).isEqualTo(forecast)
    }
}
