pluginManagement {
    includeBuild("plugins")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

enableFeaturePreview("VERSION_CATALOGS")
rootProject.name = "Funnel"

include(":app")
include(":core")
include(":features")
include(":features:top-headlines")
include(":core:api")
include(":core:theme")
include(":core:di")
include(":core:navigation")
include(":features:article")
include(":core:database")
include(":core:resources")
include(":core:base")
