plugins {
  id("ru.maxsdev.android.library")
}

android {
  namespace = "ru.maxsdev.di"
}

dependencies {
  implementation(libs.lifecycle)
  implementation(libs.lifecycle.viewmodel.ktx)
  implementation(libs.lifecycle.viewmodel.compose)
  implementation(libs.savedstate.ktx)

  implementation(libs.dagger.dagger)
  kapt(libs.dagger.compiler)
}
