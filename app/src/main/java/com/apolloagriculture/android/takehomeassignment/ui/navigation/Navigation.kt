package com.apolloagriculture.android.takehomeassignment.ui.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apolloagriculture.android.takehomeassignment.ui.screens.home.HomeScreen


@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {

        composable(route = NavigationItem.Home.route) {
            HomeScreen()
        }

    }
}
