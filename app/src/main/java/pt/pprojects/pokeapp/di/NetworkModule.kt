package pt.pprojects.pokeapp.di

import android.util.Log.d
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pt.pprojects.network.ConnectionCheckInterface
import pt.pprojects.network.RetrofitBuilder
import pt.pprojects.network.error.NetworkingErrorMapper
import pt.pprojects.network.manager.NetworkManager
import pt.pprojects.network.manager.NetworkManagerInterface
import pt.pprojects.pokeapp.BuildConfig
import pt.pprojects.pokeapp.network.ConnectionCheck

private const val NETWORKING_ERROR_MAPPER = "NETWORKING_ERROR_MAPPER"
private const val HTTP_LOGGING_INTERCEPTOR = "HTTP_LOGGING_INTERCEPTOR"

val networkModule = module {
    single<ConnectionCheckInterface> { ConnectionCheck(get()) }

    factory(named(NETWORKING_ERROR_MAPPER)) { NetworkingErrorMapper() }

    single<NetworkManagerInterface> {
        NetworkManager(
            connectionCheck = get(),
            networkingErrorMapper = get(named(NETWORKING_ERROR_MAPPER))
        )
    }

    factory<HttpLoggingInterceptor.Logger> {
        HttpLoggingInterceptor.Logger { message ->
            if (BuildConfig.DEBUG) {
                d("DEBUG", message)
            }
        }
    }

    factory<Interceptor>(named(HTTP_LOGGING_INTERCEPTOR)) {
        HttpLoggingInterceptor(get()).apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>(named(HTTP_LOGGING_INTERCEPTOR)))
            .build()
    }

    single {
        RetrofitBuilder(
            endpoint = BuildConfig.BASE_URL,
            httpClient = get()
        )
    }
}