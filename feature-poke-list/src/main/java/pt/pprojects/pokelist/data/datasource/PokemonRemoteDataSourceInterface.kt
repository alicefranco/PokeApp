package pt.pprojects.pokelist.data.datasource

import pt.pprojects.pokelist.domain.model.Pokemon

interface PokemonRemoteDataSourceInterface {
    fun getPokemons(): List<Pokemon>
    fun getPokemonCharacteristics(pokemonId: Int): Pokemon
}