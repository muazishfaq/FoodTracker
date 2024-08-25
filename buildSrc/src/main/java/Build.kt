object Build {
    private const val androidBuildToolsVersion = "8.1.1"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    private const val hiltAndroidGradlePluginVersion = "2.46"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"

    private const val jdkLibVersion = "1.1.5"
    const val jdkLibPlugin = "com.android.tools:desugar_jdk_libs:$jdkLibVersion"
}