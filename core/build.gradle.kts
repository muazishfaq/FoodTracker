plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.gms.core"
}

dependencies {
    implementation(Kotlin.kotlinStdVersion)
//    implementation("androidx.compose.ui:ui-unit-android:1.6.8")
//    implementation("androidx.compose.runtime:runtime-android:1.6.8")
    coreLibraryDesugaring(Build.jdkLibPlugin)
}
