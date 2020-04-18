package pt.pprojects.pokelist.domain.usecase

import pt.pprojects.domain.UseCaseInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.repository.PokemonRepository

class PokemonsUseCase(
    private val pokemonRepository: PokemonRepository
): UseCaseInterface<List<Pokemon>, Nothing>{

    override fun execute(refresh: Boolean, params: Nothing): List<Pokemon> {
        return pokemonRepository.getPokemons(refresh)
    }
}
