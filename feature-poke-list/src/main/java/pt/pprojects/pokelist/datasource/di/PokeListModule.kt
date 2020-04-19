package pt.pprojects.pokelist.datasource.di

import org.koin.dsl.module
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.data.repository.PokemonRepository
import pt.pprojects.pokelist.datasource.remote.PokemonRemoteDataSource
import pt.pprojects.pokelist.datasource.remote.mapper.PokemonRemoteDomainMapper
import pt.pprojects.pokelist.datasource.remote.service.PokemonService
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface
import retrofit2.Retrofit

val pokeListModule = module {
    single { get<Retrofit>().create(PokemonService::class.java) }

    single { get<PokemonRemoteDomainMapper>() }

    single<PokemonRemoteDataSourceInterface> {
        PokemonRemoteDataSource(
            networkManager = get(),
            pokemonService = get(),
            pokemonMapper = get()
        )
    }

    single<PokemonRepositoryInterface> {
        PokemonRepository(
            remoteDataSource = get()
        )
    }
}