package pt.pprojects.pokelist.data.di

import org.koin.dsl.module
import pt.pprojects.pokelist.data.repository.PokemonRepository
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface

val pokeListDataModule = module {
    single<PokemonRepositoryInterface> {
        PokemonRepository(
            remoteDataSource = get()
        )
    }
}