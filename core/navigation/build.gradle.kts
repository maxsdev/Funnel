plugins {
  id("ru.maxsdev.android.library.compose")
}

android {
  namespace = "ru.maxsdev.navigation"
}

dependencies {
  implementation(libs.navigation.compose)
}
