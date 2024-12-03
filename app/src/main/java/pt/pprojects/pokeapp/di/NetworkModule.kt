package pt.pprojects.pokeapp.di

import android.content.Context
import android.util.Log.d
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pt.pprojects.network.ConnectionCheckInterface
import pt.pprojects.network.error.NetworkingErrorMapper
import pt.pprojects.network.manager.NetworkManager
import pt.pprojects.network.manager.NetworkManagerInterface
import pt.pprojects.pokeapp.BuildConfig
import pt.pprojects.pokeapp.network.ConnectionCheck
import pt.pprojects.pokelist.datasource.remote.service.PokemonService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideNetworkingErrorMapper() = NetworkingErrorMapper()

    @Provides
    fun provideConnectionCheck(@ApplicationContext appContext: Context): ConnectionCheckInterface {
        return ConnectionCheck(appContext)
    }

    @Provides
    fun provideNetworkManager(
        connectionCheck: ConnectionCheck,
        mapper: NetworkingErrorMapper
    ): NetworkManagerInterface {
        return NetworkManager(
            connectionCheck,
            mapper
        )
    }

    @Singleton
    @Provides
    fun provideLogger(): HttpLoggingInterceptor.Logger {
        return  HttpLoggingInterceptor.Logger { message ->
            if (BuildConfig.DEBUG) {
                d("DEBUG", message)
            }
        }
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(logger: HttpLoggingInterceptor.Logger): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(logger).apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        interceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun providePokemonService(retrofit: Retrofit): PokemonService =
        retrofit.create(PokemonService::class.java)
}
