package pt.pprojects.pokelist.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.flow.Flow
import pt.pprojects.domain.DomainResult
import pt.pprojects.domain.UseCaseInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface
import pt.pprojects.pokelist.domain.usecase.PokemonCharacteristicsUseCase
import pt.pprojects.pokelist.domain.usecase.PokemonsUseCase

@Module
@InstallIn(ViewModelComponent::class)
class PokeListDomainModule {
    @Provides
    fun providePokemonsUseCase(
        pokemonRepository: PokemonRepositoryInterface
    ): UseCaseInterface<Flow<DomainResult<List<Pokemon>>>, Int> {
        return PokemonsUseCase(pokemonRepository)
    }

    @Provides
    fun providePokemonCharacteristicsUseCase(
        pokemonRepository: PokemonRepositoryInterface
    ): UseCaseInterface<Flow<DomainResult<PokemonCharacteristics>>, Int> {
        return PokemonCharacteristicsUseCase(pokemonRepository)
    }
}
