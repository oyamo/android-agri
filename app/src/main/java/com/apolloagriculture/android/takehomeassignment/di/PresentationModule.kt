package com.apolloagriculture.android.takehomeassignment.di

import com.apolloagriculture.android.takehomeassignment.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(forecastRepository = get()) }
}