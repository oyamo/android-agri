package com.apolloagriculture.android.takehomeassignment.repository.mappers

import com.apolloagriculture.android.takehomeassignment.cache.models.ForecastEntity
import com.apolloagriculture.android.takehomeassignment.network.models.ForecastDto
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DtoToEntityTest {

    private val forecastDto =
        ForecastDto(
            lowTemp = 10f,
            highTemp = 10f,
            icon = "icon",
            description = "description"
        )

    private val forecastEntity =
        ForecastEntity(
            day = "day",
            lowTemp = 10f,
            highTemp = 10f,
            icon = "icon",
            description = "description"
        )

    @Test
    fun `forecastDto is correctly mapped to forecastEntity`() {
        val result = forecastDto.toEntity(key = "day")

        assertThat(result).isEqualTo(forecastEntity)
    }

}