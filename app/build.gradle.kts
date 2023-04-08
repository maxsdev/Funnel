plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "ru.maxsdev.funnel"
        minSdk = 26

        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.asProvider().get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "ru.maxsdev.funnel"
}

dependencies {
    implementation(project(mapOf("path" to ":core:di")))
    implementation(project(mapOf("path" to ":core:api")))
    implementation(project(mapOf("path" to ":core:base")))
    implementation(project(mapOf("path" to ":core:theme")))
    implementation(project(mapOf("path" to ":core:resources")))
    implementation(project(mapOf("path" to ":features:top-headlines")))

    implementation(libs.material)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)

    implementation(libs.gson)

    implementation(libs.lifecycle)
    implementation(libs.lifecycle.viewmodel.ktx)

    implementation(libs.compose.runtime.livedata)

    implementation(libs.compose.ui)
    implementation(libs.compose.tooling.preview)
    implementation(libs.compose.tooling)
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)
    implementation(libs.compose.compiler)

    implementation(libs.navigation.compose)

    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp3.interceptor.logging)

    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.core.testing)
}
