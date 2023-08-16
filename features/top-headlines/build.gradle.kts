plugins {
  id("ru.maxsdev.android.feature")
  id("ru.maxsdev.android.library.compose")
}

android {
  namespace = "ru.maxsdev.top_headlines"
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

  implementation(libs.kotlinx.immutable.collections)

  implementation(libs.dagger.dagger)
  kapt(libs.dagger.compiler)

  implementation(libs.mvikotlin.core)
  implementation(libs.mvikotlin.main)
  implementation(libs.mvikotlin.coroutines)

  implementation(libs.decompose.core)
  implementation(libs.decompose.compose.jetbrains)
}
