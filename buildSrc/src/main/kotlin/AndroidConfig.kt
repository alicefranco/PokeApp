import org.gradle.api.JavaVersion

object AppConfig {
    const val APPLICATION_ID = "pt.pprojects.pokeapp"

    const val COMPILE_SDK_VERSION = 29
    const val MIN_SDK_VERSION = 22
    const val TARGET_SDK_VERSION = COMPILE_SDK_VERSION
    const val BUILD_TOOLS_VERSION = "29.0.2"

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val ANDROID_OPTIMIZE_FILE = "proguard-android-optimize.txt"

    val COMPILE_OPTIONS_JAVA_COMPATIBILITY = JavaVersion.VERSION_1_8
    val JVM_TARGET = JavaVersion.VERSION_1_8.toString()
}

object AndroidVersions {
    const val KOTLIN = "1.3.72"
    const val ANDROID_GRADLE = "3.6.2"
    const val KTLINT = "8.2.0"
}

object PluginIds {
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KTLINT_ANDROID = "org.jlleitschuh.gradle.ktlint"
}

object PluginDependencies {
    const val GRADLE = "com.android.tools.build:gradle:${AndroidVersions.ANDROID_GRADLE}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${AndroidVersions.KOTLIN}"
    const val KTLINT = "org.jlleitschuh.gradle:ktlint-gradle:${AndroidVersions.KTLINT}"
}

