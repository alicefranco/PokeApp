package pt.pprojects.pokeapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pt.pprojects.pokeapp.di.networkModule

class PokeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initModules()
    }

    private fun initModules() {
        startKoin {
            androidContext(this@PokeApp)
            modules(
                listOf(
                    networkModule
                )
            )
        }
    }
}