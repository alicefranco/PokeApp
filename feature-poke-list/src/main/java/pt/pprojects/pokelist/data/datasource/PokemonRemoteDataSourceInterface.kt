package pt.pprojects.pokelist.data.datasource

import io.reactivex.Single
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics

interface PokemonRemoteDataSourceInterface {
    fun getPokemons(offset: Int): Single<List<Pokemon>>
    fun getPokemonCharacteristics(pokemonId: Int): Single<PokemonCharacteristics>
}