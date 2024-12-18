import org.gradle.api.JavaVersion

object AppConfig {
    const val APPLICATION_ID = "pt.pprojects.pokeapp"
    const val MODULE_POKELIST_ID = "pt.pprojects.pokelist"

    const val COMPILE_SDK_VERSION = 34
    const val MIN_SDK_VERSION = 34
    const val BUILD_TOOLS_VERSION = "34.0.0"

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val ANDROID_OPTIMIZE_FILE = "proguard-android-optimize.txt"

    val COMPILE_OPTIONS_JAVA_COMPATIBILITY = JavaVersion.VERSION_17
    val JVM_TARGET = JavaVersion.VERSION_17.toString()
}

object AndroidVersions {
    const val KOTLIN = "1.9.22"
    const val ANDROID_GRADLE = "8.2.2"
    const val KTLINT = "8.2.0"
    const val HILT_GRADLE = "2.51.1"
}

object PluginIds {
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_LIBRARY = "kotlin"
    const val JAVA_LIBRARY = "java-library"
    const val KTLINT_ANDROID = "org.jlleitschuh.gradle.ktlint"
    const val KAPT = "kotlin-kapt"
    const val HILT = "dagger.hilt.android.plugin"
}

object PluginDependencies {
    const val GRADLE = "com.android.tools.build:gradle:${AndroidVersions.ANDROID_GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${AndroidVersions.KOTLIN}"
    const val KTLINT = "org.jlleitschuh.gradle:ktlint-gradle:${AndroidVersions.KTLINT}"
    const val HILT_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${AndroidVersions.HILT_GRADLE}"
}

