package pt.pprojects.pokelist.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.pokelist.PokeListViewModel

val pokeListPresentationModule = module {
    factory { PokemonDomainPresentationMapper() }

    viewModel {
        PokeListViewModel(
            scheduler = get(),
            pokemonsUseCase = get(),
            pokemonMapper = get()
        )
    }
}