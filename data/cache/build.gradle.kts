plugins {
    id(ProjectLevelPlugins.androidLibrary)
    id(ProjectLevelPlugins.kotlinAndroid)
    kotlin(ProjectLevelPlugins.kapt)
}

android {
    compileSdk = AndroidSdk.compileSdkVersion

    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        testInstrumentationRunner = AndroidSdk.testInstrumentationRunner
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
}

dependencies {
    implementation(Libraries.koinCore)
    implementation(Libraries.koinAndroid)

    implementation(Libraries.roomRuntime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)

    testImplementation(TestLibraries.jUnit)
    testImplementation(TestLibraries.testCore)
    testImplementation(TestLibraries.truth)
    testImplementation(TestLibraries.robolectric)
    testImplementation(TestLibraries.coroutinesTest)
}
