plugins {
    id(PluginIds.ANDROID_APPLICATION)
    id(PluginIds.KOTLIN_ANDROID)
    id(PluginIds.KTLINT_ANDROID)
}

base.archivesBaseName = "poke-app-${AppConfig.VERSION_NAME}"

android {
    namespace = AppConfig.APPLICATION_ID

    buildToolsVersion = AppConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        compileSdk = AppConfig.COMPILE_SDK_VERSION
        minSdk = AppConfig.MIN_SDK_VERSION

        applicationId = AppConfig.APPLICATION_ID
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = AppConfig.TEST_INSTRUMENTATION_RUNNER
    }

    compileOptions {
        sourceCompatibility = AppConfig.COMPILE_OPTIONS_JAVA_COMPATIBILITY
        targetCompatibility = AppConfig.COMPILE_OPTIONS_JAVA_COMPATIBILITY
    }

    buildTypes {
        getByName(FlavorConfig.BuildType.DEBUG) {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
        }

        getByName(FlavorConfig.BuildType.RELEASE) {
            isMinifyEnabled = true
            isShrinkResources = true

            // proguardFiles(getDefaultProguardFile(AppConfig.ANDROID_OPTIMIZE_FILE))
        }
    }

    flavorDimensions += FlavorConfig.DEFAULT_DIMENSION_NAME

    productFlavors {
        create(FlavorConfig.Flavor.DEVELOPMENT) {
            dimension = FlavorConfig.DEFAULT_DIMENSION_NAME

            buildConfigField("String", "BASE_URL", FlavorConfig.Endpoint.DEVELOPMENT)
        }

        create(FlavorConfig.Flavor.PRODUCTION) {
            dimension = FlavorConfig.DEFAULT_DIMENSION_NAME

            buildConfigField("String", "BASE_URL", FlavorConfig.Endpoint.PRODUCTION)
        }
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
    implementation(project(ProjectModules.Feature.POKELIST))
    implementation(project(ProjectModules.Shared.DOMAIN))
    implementation(project(ProjectModules.Shared.NETWORK))

    implementation(Libraries.KOTLIN_STD_LIB)
    implementation(Libraries.APP_COMPAT)
    implementation(Libraries.CORE_KTX)
    implementation(Libraries.CONSTRAINT_LAYOUT)

    implementation(Libraries.COMPOSE_BOM)
    implementation(Libraries.COMPOSE_MATERIAL)
    implementation(Libraries.COMPOSE_PREVIEW)
    implementation(Libraries.COMPOSE_UI)
    implementation(Libraries.COMPOSE_RUNTIME)
    implementation(Libraries.COMPOSE_ACTIVITY)
    implementation(Libraries.COMPOSE_GRAPHICS)
    implementation(Libraries.COMPOSE_COIL)
    implementation(Libraries.COMPOSE_COIL_NETWORK)
    implementation(Libraries.COMPOSE_NAVIGATION)

    debugImplementation(Libraries.COMPOSE_TOOLING)

    implementation(Libraries.KOIN)

    implementation(Libraries.RX_JAVA)
    implementation(Libraries.RETROFIT)
    implementation(Libraries.RETROFIT_CONVERTER_GSON)
    implementation(Libraries.RETROFIT_RX_JAVA_ADAPTER)

    implementation(Libraries.OKHTTP)
    implementation(Libraries.OKHTTP_LOGGER)

    testImplementation(Libraries.JUNIT)
    androidTestImplementation(Libraries.TEST_RUNNER)
    androidTestImplementation(Libraries.ESPRESSO)
}