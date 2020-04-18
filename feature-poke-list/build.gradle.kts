plugins {
    id(PluginIds.ANDROID_LIBRARY)
    id(PluginIds.KOTLIN_ANDROID)
    id(PluginIds.KOTLIN_ANDROID_EXTENSIONS)
    id(PluginIds.KTLINT_ANDROID)
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

android {
    compileSdkVersion(AppConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AppConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(AppConfig.MIN_SDK_VERSION)
        targetSdkVersion(AppConfig.TARGET_SDK_VERSION)

        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = AppConfig.TEST_INSTRUMENTATION_RUNNER
    }

    compileOptions {
        sourceCompatibility = AppConfig.COMPILE_OPTIONS_JAVA_COMPATIBILITY
        targetCompatibility = AppConfig.COMPILE_OPTIONS_JAVA_COMPATIBILITY
    }

    buildTypes {
        getByName(FlavorConfig.BuildType.DEBUG) {}

        getByName(FlavorConfig.BuildType.RELEASE) {
            isMinifyEnabled = true

            // proguardFiles(getDefaultProguardFile(AppConfig.ANDROID_OPTIMIZE_FILE))
        }
    }

    flavorDimensions(FlavorConfig.DEFAULT_DIMENSION_NAME)

    productFlavors {
        create(FlavorConfig.Flavor.DEVELOPMENT) {
            dimension = FlavorConfig.DEFAULT_DIMENSION_NAME
        }

        create(FlavorConfig.Flavor.PRODUCTION) {
            dimension = FlavorConfig.DEFAULT_DIMENSION_NAME
        }
    }

    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }
}

dependencies {
    implementation(project(ProjectModules.Shared.DOMAIN))
    implementation(project(ProjectModules.Shared.NETWORK))

    implementation(Libraries.KOTLIN_STD_LIB)
    implementation(Libraries.APP_COMPAT)
    implementation(Libraries.CORE_KTX)
    implementation(Libraries.CONSTRAINT_LAYOUT)
    testImplementation(Libraries.JUNIT)
    androidTestImplementation(Libraries.TEST_RUNNER)
    androidTestImplementation(Libraries.ESPRESSO)
}
