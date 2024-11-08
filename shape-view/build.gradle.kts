import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    id("maven-publish")
}

android {
    namespace = "dylan.kwon.shapeview"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        aarMetadata {
            minCompileSdk = 24
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    dataBinding {
        enable = true
    }
}

publishing {
    val publishProperties = loadProperties(
        rootProject.file("publish.properties").path
    )
    val versionProperties = loadProperties(
        rootProject.file("version.properties").path
    )
    repositories {
        maven(publishProperties["githubRepoUrl"].toString()) {
            credentials {
                username = publishProperties["githubUserName"].toString()
                password = publishProperties["githubToken"].toString()
            }
        }
    }
    publications {
        register<MavenPublication>(name) {
            groupId = publishProperties["groupId"].toString()
            artifactId = publishProperties["artifactId"].toString()
            version = versionProperties["versionName"].toString()

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}
