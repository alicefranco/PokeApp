package pt.pprojects.pokelist.domain.repository

import pt.pprojects.pokelist.domain.model.Pokemon

interface PokemonRepository {
    fun getPokemons(refresh: Boolean): List<Pokemon>
    fun getPokemonCharacteristics(pokemonId: Int): Pokemon
}