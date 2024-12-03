package pt.pprojects.pokelist.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.data.repository.PokemonRepository
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface


@Module
@InstallIn(SingletonComponent::class)
class PokeListDataModule {
    @Provides
    fun providePokemonRepository(
        remoteDataSource: PokemonRemoteDataSourceInterface
    ): PokemonRepositoryInterface {
        return PokemonRepository(remoteDataSource)
    }
}
