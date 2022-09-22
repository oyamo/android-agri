buildscript {

    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath(ProjectLevelPlugins.kotlin)
        classpath(ProjectLevelPlugins.gradle)
        classpath(ProjectLevelPlugins.googleServices)
        classpath(ProjectLevelPlugins.firebaseAppDistribution)
        classpath(ProjectLevelPlugins.firebaseCrashlytics)
        classpath(ProjectLevelPlugins.firebasePerformance)
    }
}

plugins {
    id(ProjectLevelPlugins.ktLint) version Versions.ktLint
    id(ProjectLevelPlugins.detekt) version (Versions.detekt)
}

subprojects {
    apply(plugin = ProjectLevelPlugins.ktLint)
    ktlint {
        debug.set(true)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        outputColorName.set("RED")
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }

    apply(plugin = ProjectLevelPlugins.detekt)
    detekt {
        parallel = true
        config = files("${project.rootDir}/config/detekt/detekt.yml")
    }
}

tasks.register("clean").configure {
    delete("build")
}
