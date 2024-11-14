plugins {
    id(PluginIds.ANDROID_LIBRARY)
    id(PluginIds.KOTLIN_ANDROID)
    id(PluginIds.KTLINT_ANDROID)
    id(PluginIds.KAPT)
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

android {
    namespace = AppConfig.MODULE_POKELIST_ID

    buildToolsVersion = AppConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        compileSdk = AppConfig.COMPILE_SDK_VERSION
        minSdk = AppConfig.MIN_SDK_VERSION

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

    flavorDimensions += FlavorConfig.DEFAULT_DIMENSION_NAME

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

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.KOTLIN_COMPILER_EXT
    }

    kotlinOptions {
        jvmTarget = "19"
    }

}

dependencies {
    implementation(project(ProjectModules.Shared.DOMAIN))
    implementation(project(ProjectModules.Shared.NETWORK))

    implementation(Libraries.KOTLIN_STD_LIB)
    implementation(Libraries.APP_COMPAT)
    implementation(Libraries.CORE_KTX)

    implementation(Libraries.COMPOSE_BOM)
    implementation(Libraries.COMPOSE_MATERIAL)
    implementation(Libraries.COMPOSE_PREVIEW)
    implementation(Libraries.COMPOSE_NAVIGATION)
    implementation(Libraries.COMPOSE_UI)
    implementation(Libraries.COMPOSE_RUNTIME)
    implementation(Libraries.COMPOSE_ACTIVITY)
    implementation(Libraries.COMPOSE_GRAPHICS)
    implementation(Libraries.COMPOSE_COIL)
    implementation(Libraries.COMPOSE_COIL_NETWORK)
    implementation(Libraries.COMPOSE_LIFECYCLE)

    implementation(Libraries.LIFECYCLE_RUNTIME)
    implementation(Libraries.LIFECYCLE_COMPOSE)
    implementation(Libraries.LIFECYCLE_VIEWMODEL)
    implementation(Libraries.MATERIAL_DESIGN)

    debugImplementation(Libraries.COMPOSE_TOOLING)

    implementation(Libraries.COROUTINES_CORE)
    implementation(Libraries.COROUTINES_ANDROID)
    implementation(Libraries.RETROFIT)
    implementation(Libraries.RETROFIT_CONVERTER_GSON)
    implementation(Libraries.RETROFIT_RX_JAVA_ADAPTER)

    implementation(Libraries.KOIN)
    implementation(Libraries.KOIN_CORE)
    implementation(Libraries.KOIN_COMPOSE)

    testImplementation(Libraries.JUNIT)
    testImplementation(Libraries.ASSERTJ)
    testImplementation(Libraries.MOCKITO)
    testImplementation(Libraries.ANDROID_TEST_ARCH_CORE)
    androidTestImplementation(Libraries.TEST_RUNNER)
    androidTestImplementation(Libraries.ESPRESSO)
    androidTestImplementation(Libraries.COMPOSE_BOM)
}
