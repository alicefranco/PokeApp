package pt.pprojects.pokelist.domain.usecase

import pt.pprojects.domain.UseCaseInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.repository.PokemonRepository

class PokemonCharacteristicsUseCase(
    private val pokemonRepository: PokemonRepository
): UseCaseInterface<Pokemon, Int>{

    override fun execute(refresh: Boolean, params: Int): Pokemon {
        return pokemonRepository.getPokemonCharacteristics(pokemonId = params)
    }
}
