import org.gradle.util.internal.GUtil.loadProperties

private val deployProperties = loadProperties(
    file("publish.properties")
)

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven(deployProperties["githubRepoUrl"].toString()) {
            credentials {
                username = deployProperties["githubUserName"].toString()
                password = deployProperties["githubToken"].toString()
            }
        }
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "android-shape-view"
include(":sample")
include(":shape-view")
