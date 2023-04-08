plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ru.maxsdev.top_headlines"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.asProvider().get()
    }
    kotlinOptions {
        jvmTarget = "19"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":core:di")))
    implementation(project(mapOf("path" to ":core:api")))
    implementation(project(mapOf("path" to ":core:theme")))

    implementation(libs.paging)
    implementation(libs.paging.compose)

    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    implementation(libs.compose.compiler)

    implementation(libs.navigation.compose)

    implementation(libs.coil.compose)

    implementation(libs.bundles.compose)

    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
}
