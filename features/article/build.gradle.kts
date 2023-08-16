plugins {
  id("ru.maxsdev.android.feature")
  id("ru.maxsdev.android.library.compose")
}

android {
  namespace = "ru.maxsdev.article"
}

dependencies {
  implementation(libs.lifecycle)
  implementation(libs.lifecycle.viewmodel.ktx)

  implementation(libs.compose.ui)
  implementation(libs.compose.tooling.preview)
  implementation(libs.compose.tooling)
  implementation(libs.compose.material3)
  implementation(libs.compose.activity)

  implementation(libs.navigation.compose)

  implementation(libs.dagger.dagger)
  kapt(libs.dagger.compiler)
}
