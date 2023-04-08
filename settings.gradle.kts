pluginManagement {
    includeBuild("plugins")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            url = java.net.URI.create("https://jitpack.io")
        }
    }
}

rootProject.name = "Funnel"

include(":app")
include(":features")
include(":features:top-headlines")
include(":features:article")
include(":core")
include(":core:navigation")
include(":core:api")
include(":core:theme")
include(":core:di")
include(":core:database")
include(":core:resources")
include(":core:base")
