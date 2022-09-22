package com.apolloagriculture.android.takehomeassignment.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val forecastRepository: ForecastRepository) : ViewModel() {

    private val _forecast = MutableStateFlow<List<Forecast>?>(null)
    val forecast = _forecast.asStateFlow()

    init {
        fetchForecast()
    }

    private fun fetchForecast() = viewModelScope.launch {
        forecastRepository.getForecast().collect { foreCasts ->
            Log.e("TAG", "Response in VM: $foreCasts")

            _forecast.value = foreCasts
        }
    }

}