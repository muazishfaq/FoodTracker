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
    coreLibraryDesugaring(Build.jdkLibPlugin)
}
