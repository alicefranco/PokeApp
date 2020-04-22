package pt.pprojects.pokelist.datasource.di

import org.koin.dsl.module
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.datasource.remote.PokemonRemoteDataSource
import pt.pprojects.pokelist.datasource.remote.mapper.PokemonRemoteDomainMapper
import pt.pprojects.pokelist.datasource.remote.service.PokemonService
import retrofit2.Retrofit

val pokeListDatasourceModule = module {
    single { get<Retrofit>().create(PokemonService::class.java) }

    single { PokemonRemoteDomainMapper() }

    single<PokemonRemoteDataSourceInterface> {
        PokemonRemoteDataSource(
            networkManager = get(),
            pokemonService = get(),
            pokemonMapper = get()
        )
    }
}