plugins {
  id("ru.maxsdev.android.library.compose")
}

android {
  namespace = "ru.maxsdev.theme"
}

dependencies {
  implementation(libs.bundles.compose)
  implementation(libs.compose.tooling)
  implementation(libs.compose.runtime)
  implementation(libs.compose.compiler)
}
