package pt.pprojects.pokelist.domain.usecase

import kotlinx.coroutines.flow.Flow
import pt.pprojects.domain.DomainResult
import pt.pprojects.domain.UseCaseInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface
import javax.inject.Inject

class PokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepositoryInterface
) : UseCaseInterface<Flow<DomainResult<List<Pokemon>>>, Int> {

    override suspend fun execute(refresh: Boolean, params: Int): Flow<DomainResult<List<Pokemon>>> {
        return pokemonRepository.getPokemons(refresh, offset = params)
    }
}
