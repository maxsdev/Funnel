plugins {
  id("ru.maxsdev.android.library")
}

android {
  namespace = "ru.maxsdev.base"
}

dependencies {

  implementation(libs.android.core.ktx)
  implementation(libs.appcompat)
  implementation(libs.material)
  testImplementation(libs.junit)
}
