plugins {
  id("ru.maxsdev.android.library")
}

android {
  namespace = "ru.maxsdev.database"
}

dependencies {
  kapt(libs.room.runtime)
  kapt(libs.room.ktx)
  kapt(libs.room.compiler)
}
