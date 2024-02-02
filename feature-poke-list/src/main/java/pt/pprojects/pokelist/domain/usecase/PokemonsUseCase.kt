package pt.pprojects.pokelist.domain.usecase

import io.reactivex.rxjava3.core.Single
import pt.pprojects.domain.UseCaseInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface

class PokemonsUseCase(
    private val pokemonRepository: PokemonRepositoryInterface
) : UseCaseInterface<Single<List<Pokemon>>, Int> {

    override fun execute(refresh: Boolean, params: Int): Single<List<Pokemon>> {
        return pokemonRepository.getPokemons(refresh, offset = params)
    }
}
