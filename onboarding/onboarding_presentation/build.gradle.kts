plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.gms.onboarding_presentation"
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.onboardingDomain))

    implementation(Kotlin.kotlinStdVersion)
    coreLibraryDesugaring(Build.jdkLibPlugin)
}