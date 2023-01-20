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
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    packagingOptions {
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

    implementation(libs.navigation.compose)

    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp3.interceptor.logging)

    testImplementation(libs.junit)
    testImplementation("org.mockito:mockito-core:5.0.0")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
}
