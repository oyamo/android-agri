package com.apolloagriculture.android.takehomeassignment.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolloagriculture.android.takehomeassignment.domain.models.Forecast
import com.apolloagriculture.android.takehomeassignment.domain.repository.ForecastRepository
import com.apolloagriculture.android.takehomeassignment.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val forecastRepository: ForecastRepository) : ViewModel() {

    private val _forecastUiState = MutableStateFlow<UiState<List<Forecast>>>(UiState.Loading())
    val forecastUiState = _forecastUiState.asStateFlow()

    init {
        fetchForecast()
    }

    private fun fetchForecast() = viewModelScope.launch {
        _forecastUiState.value = UiState.Loading()

        try {
            forecastRepository.getForecast().collect { foreCasts ->
                _forecastUiState.value = UiState.Success(data = foreCasts)
            }
        } catch (e: Exception) {
            _forecastUiState.value = UiState.Error(error = e.message)
        }
    }

}