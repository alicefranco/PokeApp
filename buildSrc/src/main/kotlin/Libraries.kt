object Libraries {
    //DEFAULT
    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${AndroidVersions.KOTLIN}"
    
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"

    //COMPOSE
    const val COMPOSE_BOM = "androidx.compose:compose-bom:2024.09.03"
    const val COMPOSE_MATERIAL = "androidx.compose.material3:material3:${Versions.COMPOSE_MATERIAL}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.COMPOSE}"
    const val COMPOSE_GRAPHICS = "androidx.compose.ui:ui-graphics:${Versions.COMPOSE}"
    const val COMPOSE_COIL = "io.coil-kt.coil3:coil-compose:${Versions.COMPOSE_COIL}"
    const val COMPOSE_COIL_NETWORK = "io.coil-kt.coil3:coil-network-okhttp:${Versions.COMPOSE_COIL}"

    //LIFECYCLE
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE}"
    const val LIFECYCLE_COMPOSE = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.LIFECYCLE}"
    const val MATERIAL_DESIGN = "com.google.android.material:material:${Versions.MATERIAL_DESIGN}"

    //TESTING
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ASSERTJ = "org.assertj:assertj-core:${Versions.ASSERTJ}"
    const val MOCKITO = "org.mockito:mockito-core:${Versions.MOCKITO}"
    const val ANDROID_TEST_ARCH_CORE = "androidx.arch.core:core-testing:${Versions.ANDROID_TEST_ARCH_CORE}"
    const val TEST_RUNNER = "androidx.test:runner:${Versions.TEST_RUNNER}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    //NETWORK
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val RETROFIT_RX_JAVA_ADAPTER = "com.squareup.retrofit2:adapter-rxjava3:${Versions.RETROFIT}"

    //DEPENDENCY INJECTION
    const val KOIN = "io.insert-koin:koin-android:${Versions.KOIN}"
}