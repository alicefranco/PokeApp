package pt.pprojects.pokelist.domain.repository

import io.reactivex.Single
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics

interface PokemonRepositoryInterface {
    fun getPokemons(refresh: Boolean = false, offset: Int): Single<List<Pokemon>>
    fun getPokemonCharacteristics(refresh: Boolean = false, pokemonId: Int): Single<PokemonCharacteristics>
}