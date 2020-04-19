package pt.pprojects.pokelist.domain.usecase

import io.reactivex.Single
import pt.pprojects.domain.UseCaseInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface

class PokemonCharacteristicsUseCase(
    private val pokemonRepository: PokemonRepositoryInterface
) : UseCaseInterface<Single<PokemonCharacteristics>, Int> {

    override fun execute(refresh: Boolean, params: Int): Single<PokemonCharacteristics> {
        return pokemonRepository.getPokemonCharacteristics(pokemonId = params)
    }
}
