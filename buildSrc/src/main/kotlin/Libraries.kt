object Libraries {
    //DEFAULT
    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${AndroidVersions.KOTLIN}"
    
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"

    //UI
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
    const val MATERIAL_DESIGN = "com.google.android.material:material:${Versions.MATERIAL_DESIGN}"

    //LIFECYCLE
    const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"

    //TESTING
    const val JUNIT = "androidx.test.ext:junit:${Versions.JUNIT}"
    const val TEST_RUNNER = "androidx.test:runner:${Versions.TEST_RUNNER}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    //NETWORK
    const val KOTLIN_SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.KOTLIN_SERIALIZATION}"

    const val RX_JAVA = "io.reactivex.rxjava2:rxjava:${Versions.RX_JAVA}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_RX_JAVA_ADAPTER = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT_RX_JAVA_ADAPTER}"
    const val RETROFIT_KOTLIN_SERIALIZATION_CONVERTER = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.RETROFIT_KOTLIN_SERIALIZATION_CONVERTER}"

    //DEPENDENCY INJECTION
    const val KOIN_CORE = "org.koin:koin-core:${Versions.KOIN}"
    const val KOIN_ANDROID = "org.koin:koin-android:${Versions.KOIN}"
    const val KOIN_SCOPE = "org.koin:koin-androidx-scope:${Versions.KOIN}"
    const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"

}