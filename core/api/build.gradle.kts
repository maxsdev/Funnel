plugins {
  id("ru.maxsdev.android.library")
}

android {
  namespace = "ru.maxsdev.api"
}

dependencies {

  implementation(libs.gson)

  implementation(libs.retrofit.retrofit)
  implementation(libs.retrofit.converter.gson)
  implementation(libs.okhttp3.interceptor.logging)

  implementation(libs.dagger.dagger)
  kapt(libs.dagger.compiler)
}
