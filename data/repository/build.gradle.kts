plugins {
    id(ProjectLevelPlugins.androidLibrary)
    id(ProjectLevelPlugins.kotlinAndroid)
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

    api(project(BuildModules.network))
    api(project(BuildModules.cache))

    implementation(Libraries.koinCore)

    testImplementation(TestLibraries.jUnit)
    testImplementation(TestLibraries.testCore)
    testImplementation(TestLibraries.androidArchCoreTesting)
    testImplementation(TestLibraries.truth)
    testImplementation(TestLibraries.coroutinesTest)

    testImplementation(project(BuildModules.network)) // Needed to be able to share test resources - MockWebServer
}
