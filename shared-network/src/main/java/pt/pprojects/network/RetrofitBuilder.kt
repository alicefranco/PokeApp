package pt.pprojects.network

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val gsonFactory = GsonConverterFactory.create()

    operator fun invoke(
        endpoint: String,
        httpClient: OkHttpClient,
        convertFactory: Converter.Factory = gsonFactory,
    ) = with(Retrofit.Builder()) {
        baseUrl(endpoint)
        client(httpClient)
        addConverterFactory(convertFactory)
        build()
    }
}
