package pt.pprojects.pokelist.domain.usecase

import kotlinx.coroutines.flow.Flow
import pt.pprojects.domain.DomainResult
import pt.pprojects.domain.UseCaseInterface
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface
import javax.inject.Inject

class PokemonCharacteristicsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepositoryInterface
) : UseCaseInterface<Flow<DomainResult<PokemonCharacteristics>>, Int> {

    override suspend fun execute(refresh: Boolean, params: Int): Flow<DomainResult<PokemonCharacteristics>> {
        return pokemonRepository.getPokemonCharacteristics(pokemonId = params)
    }
}
