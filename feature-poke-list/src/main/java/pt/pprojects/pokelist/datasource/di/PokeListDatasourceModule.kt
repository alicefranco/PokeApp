package pt.pprojects.pokelist.datasource.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pt.pprojects.network.manager.NetworkManagerInterface
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.datasource.remote.PokemonRemoteDataSource
import pt.pprojects.pokelist.datasource.remote.mapper.PokemonRemoteDomainMapper
import pt.pprojects.pokelist.datasource.remote.service.PokemonService

@Module
@InstallIn(SingletonComponent::class)
class PokeListDatasourceModule {

    @Provides
    fun providePokemonRemoteDomainMapper() = PokemonRemoteDomainMapper()

    @Provides
    fun providePokemonRemoteDataSource(
        networkManager: NetworkManagerInterface,
        pokemonService: PokemonService,
        pokemonMapper: PokemonRemoteDomainMapper
    ): PokemonRemoteDataSourceInterface {
        return PokemonRemoteDataSource(
            networkManager,
            pokemonService,
            pokemonMapper
        )
    }
}