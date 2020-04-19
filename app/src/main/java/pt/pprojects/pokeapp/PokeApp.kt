package pt.pprojects.pokeapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pt.pprojects.pokeapp.di.appModule
import pt.pprojects.pokeapp.di.networkModule
import pt.pprojects.pokelist.data.di.pokeListDataModule
import pt.pprojects.pokelist.datasource.di.pokeListDatasourceModule
import pt.pprojects.pokelist.domain.di.pokeListDomainModule
import pt.pprojects.pokelist.presentation.di.pokeListPresentationModule

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
                    appModule,
                    networkModule,
                    pokeListDataModule,
                    pokeListDatasourceModule,
                    pokeListDomainModule,
                    pokeListPresentationModule
                )
            )
        }
    }
}