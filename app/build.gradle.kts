plugins {
    id(ProjectLevelPlugins.androidApplication)
    kotlin(ProjectLevelPlugins.android)

    // id(ProjectLevelPlugins.appDistribution)
    // id(ProjectLevelPlugins.googleService)
    // id(ProjectLevelPlugins.crashlytics)
    // id(ProjectLevelPlugins.performance)
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        applicationId = AndroidSdk.applicationId

        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = AndroidSdk.testInstrumentationRunner

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            // proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}

dependencies {

    implementation(project(BuildModules.domain))
    implementation(project(BuildModules.repository))

    implementation(Libraries.androidxCore)

    implementation(Libraries.composeUI)
    implementation(Libraries.composeMaterial)
    implementation(Libraries.composeToolingPreview)
    implementation(Libraries.composeActivity)

    implementation(Libraries.navigation)

    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCompose)

    implementation(Libraries.lifecycleLiveData)
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.composeLivedata)

    implementation(Libraries.timber)

    implementation(Libraries.coil)

    implementation(Libraries.palette)

    // implementation(Libraries.firebaseCrashlytics)
    // implementation(Libraries.firebaseAnalytics)
    // implementation(Libraries.firebasePerformance)

    implementation(Libraries.splashScreen)

    debugImplementation(Libraries.leakCanary)

    testImplementation(TestLibraries.jUnit)
    testImplementation(TestLibraries.androidArchCoreTesting)
    testImplementation(TestLibraries.coroutinesTest)
    testImplementation(TestLibraries.truth)
    testImplementation(TestLibraries.robolectric)
    testImplementation(TestLibraries.jUnitCompose)

    androidTestImplementation(TestLibraries.espresso)
    androidTestImplementation(TestLibraries.composeUiTest)

    debugImplementation(Libraries.composeTooling)
    debugImplementation(Libraries.composeTestManifest)
}
