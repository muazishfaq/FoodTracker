plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.gms.onboarding_domain"
}

dependencies {
    implementation(project(Modules.core))

    implementation(Kotlin.kotlinStdVersion)
    coreLibraryDesugaring(Build.jdkLibPlugin)
}