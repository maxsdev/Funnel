plugins {
  id("ru.maxsdev.android.library")
}

android {
  namespace = "ru.maxsdev.resources"
}

dependencies {
  implementation(libs.android.core.ktx)
  implementation(libs.appcompat)
  implementation(libs.material)
  testImplementation(libs.junit)
}
