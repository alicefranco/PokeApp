package pt.pprojects.pokeapp.di

import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val appModule = module {
    single { Schedulers.io() }
}