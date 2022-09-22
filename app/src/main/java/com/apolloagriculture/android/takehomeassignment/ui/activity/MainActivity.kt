package com.apolloagriculture.android.takehomeassignment.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.apolloagriculture.android.takehomeassignment.R
import com.apolloagriculture.android.takehomeassignment.ui.navigation.Navigation
import com.apolloagriculture.android.takehomeassignment.ui.theme.ApolloAndroidTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {

            ApolloAndroidTheme(darkTheme = isSystemInDarkTheme()) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.h4,
                        maxLines = 1,
                        fontSize = 20.sp,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onSurface
                    )
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    ) {

        Navigation(navController = navController, paddingValues = it)
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApolloAndroidTheme {
        MainScreen()
    }
}
