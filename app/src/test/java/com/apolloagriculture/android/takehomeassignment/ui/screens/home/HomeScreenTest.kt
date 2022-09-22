package com.apolloagriculture.android.takehomeassignment.ui.screens.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.apolloagriculture.android.takehomeassignment.ui.theme.ApolloAndroidTheme
import com.apolloagriculture.android.takehomeassignment.utils.FakeForecastRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"])
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `should display feed items`() {
        val fakeViewModel = HomeViewModel(forecastRepository = FakeForecastRepository())

        composeTestRule.setContent {
            ApolloAndroidTheme {
                HomeScreen(viewModel = fakeViewModel)
            }
        }

        composeTestRule.onNodeWithTag("forecast_lazy_column").assertExists()
        composeTestRule.onNodeWithTag("forecast_lazy_column").assertIsDisplayed()
    }
}