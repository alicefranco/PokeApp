package pt.pprojects.pokelist.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.pokelist.PokeListViewModel
import pt.pprojects.pokelist.presentation.pokemondetails.PokemonDetailsViewModel

val pokeListPresentationModule = module {
    factory { PokemonDomainPresentationMapper() }

    viewModel {
        PokeListViewModel(
            pokemonsUseCase = get(),
            pokemonMapper = get()
        )
    }

    viewModel {
        PokemonDetailsViewModel(
            pokemonCharacteristicsUseCase = get(),
            pokemonMapper = get()
        )
    }
}