plugins {
    id(ProjectLevelPlugins.androidLibrary)
    id(ProjectLevelPlugins.kotlinAndroid)
    kotlin(ProjectLevelPlugins.kotlinXSerialization) version Versions.kotlinSerialization
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
    implementation(project(BuildModules.domain))

    implementation(Libraries.koinCore)

    implementation(Libraries.ktorCore)
    implementation(Libraries.ktorAndroid)
    implementation(Libraries.ktorSerialization)
    implementation(Libraries.ktorLogging)

    testImplementation(TestLibraries.jUnit)
    testImplementation(TestLibraries.testCore)
    testImplementation(TestLibraries.truth)
    testImplementation(TestLibraries.ktorMock)
}
