plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.gms.tracker_domain"
}

dependencies {
    implementation(Kotlin.kotlinStdVersion)
    coreLibraryDesugaring(Build.jdkLibPlugin)
}