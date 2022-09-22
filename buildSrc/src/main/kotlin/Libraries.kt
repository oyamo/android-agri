object Libraries {
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"

    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val composeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    const val kotlinxDateTime="org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"

    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val palette = "androidx.palette:palette:${Versions.palette}"

    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx:18.2.12"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx:21.1.0"
    const val firebasePerformance = "com.google.firebase:firebase-perf-ktx:20.1.0"

    const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"

    const val leakCanary="com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val ktorAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
}
