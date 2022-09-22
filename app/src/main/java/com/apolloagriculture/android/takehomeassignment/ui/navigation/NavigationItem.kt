package com.apolloagriculture.android.takehomeassignment.ui.navigation

import androidx.annotation.StringRes
import com.apolloagriculture.android.takehomeassignment.R

sealed class NavigationItem(val route: String, @StringRes val title: Int) {

    object Home : NavigationItem("home", R.string.title_home)

}
