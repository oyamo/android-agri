plugins {
    id(ProjectLevelPlugins.javaLibrary)
    id(ProjectLevelPlugins.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api(Libraries.coroutines)
}
