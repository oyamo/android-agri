package com.apolloagriculture.android.takehomeassignment.ui.screens.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val forecastRepository: ForecastRepository) : ViewModel() {

    private val _forecast = MutableLiveData<List<Forecast>?>(null)
    val forecast: LiveData<List<Forecast>?> get() = _forecast

    init {
        fetchForecast()
    }

    private fun fetchForecast() = viewModelScope.launch {
        val response = forecastRepository.fetchForecast()

        Log.e("TAG", "Response in VM: $response")

        _forecast.value = response
    }

}