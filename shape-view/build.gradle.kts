import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.kapt)
    alias(libs.plugins.vanniktech.maven.publish)
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

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}

mavenPublishing {
    val publishProperties = loadProperties(
        rootProject.file("publish.properties").path
    )

    val versionProperties = loadProperties(
        rootProject.file("version.properties").path
    )

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(
        groupId = publishProperties["groupId"].toString(),
        artifactId = publishProperties["artifactId"].toString(),
        version = versionProperties["versionName"].toString()
    )

    pom {
        name = publishProperties["artifactId"].toString()
        description = publishProperties["description"].toString()
        url = publishProperties["repository"].toString()

        licenses {
            license {
                name = publishProperties["licenseName"].toString()
                url = publishProperties["licenseUrl"].toString()
            }
        }

        developers {
            developer {
                id = publishProperties["developerId"].toString()
                name = publishProperties["developerName"].toString()
                email = publishProperties["developerEmail"].toString()
                url = publishProperties["developerUrl"].toString()
            }
        }

        scm {
            url = this@pom.url
            connection = publishProperties["scmConnection"].toString()
            developerConnection = publishProperties["scmDeveloperConnection"].toString()
        }
    }
}
