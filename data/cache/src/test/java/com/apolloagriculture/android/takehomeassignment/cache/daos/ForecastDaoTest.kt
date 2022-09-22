package com.apolloagriculture.android.takehomeassignment.cache.daos

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.apolloagriculture.android.takehomeassignment.cache.AppDatabase
import com.apolloagriculture.android.takehomeassignment.cache.models.ForecastEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ForecastDaoTest {

    private val foreCastToday = ForecastEntity(
        day = "today",
        lowTemp = 10.45f,
        highTemp = 12.34f,
        icon = "CLEAR_DAY",
        description = "clear sky"
    )

    private val foreCastTomorrow = ForecastEntity(
        day = "tomorrow",
        lowTemp = 11.45f,
        highTemp = 13.34f,
        icon = "SCATTERED_CLOUDS_DAY",
        description = "scattered clouds"
    )

    private val foreCasts = mutableListOf(foreCastToday)

    private lateinit var appDatabase: AppDatabase
    private lateinit var forecastDao: ForecastDao // Subject under test

    @Before
    fun setUp() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        forecastDao = appDatabase.forecastDao()
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    fun `list of forecasts are saved correctly`() = runBlocking {
        forecastDao.saveForecast(forecast = foreCasts)

        val result = forecastDao.getForecast().first()

        assertThat(result.size).isEqualTo(1)
        assertThat(result).isEqualTo(foreCasts)
    }

    @Test
    fun `forecast with conflicting days are overwritten`() = runBlocking {
        forecastDao.saveForecast(forecast = foreCasts)

        val result = forecastDao.getForecast().first()

        assertThat(result.size).isEqualTo(1)
        assertThat(result).isEqualTo(foreCasts)

        val newForeCastToday = ForecastEntity(
            day = "today",
            lowTemp = 15.45f,
            highTemp = 18.34f,
            icon = "BROKEN_OVERCAST_CLOUDS_DAY",
            description = "clear sky"
        )
        val newForeCasts = mutableListOf(newForeCastToday) // Updated/Corrected values from network

        forecastDao.saveForecast(forecast = newForeCasts)

        val newResult = forecastDao.getForecast().first()

        assertThat(newResult).isNotEqualTo(result)
        assertThat(newResult.size).isEqualTo(1)
        assertThat(newResult).isEqualTo(newForeCasts)
    }

    @Test
    fun `forecast with different days are added to existing records`() = runBlocking {
        forecastDao.saveForecast(forecast = foreCasts)

        val result = forecastDao.getForecast().first()

        assertThat(result.size).isEqualTo(1)
        assertThat(result).isEqualTo(foreCasts)

        foreCasts.add(foreCastTomorrow) // New data from network

        forecastDao.saveForecast(forecast = foreCasts)

        val newResult = forecastDao.getForecast().first()

        assertThat(newResult).isNotEqualTo(result)
        assertThat(newResult.size).isEqualTo(2)
    }

}