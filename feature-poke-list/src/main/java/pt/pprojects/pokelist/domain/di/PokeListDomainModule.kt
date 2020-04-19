package pt.pprojects.pokelist.domain.di

import org.koin.dsl.module
import pt.pprojects.pokelist.domain.usecase.PokemonsUseCase

val pokeListDomainModule = module {
    factory { PokemonsUseCase(get()) }
}
