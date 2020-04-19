package pt.pprojects.pokelist.data.datasource

import io.reactivex.Single
import pt.pprojects.pokelist.domain.model.Pokemon

interface PokemonCacheDataSourceInterface {
    fun getPokemons(): Single<List<Pokemon>>
    fun getPokemonCharacteristics(pokemonId: Int): Single<Pokemon>
}