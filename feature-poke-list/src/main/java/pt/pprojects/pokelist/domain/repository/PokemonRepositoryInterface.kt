package pt.pprojects.pokelist.domain.repository

import pt.pprojects.pokelist.domain.model.Pokemon

interface PokemonRepositoryInterface {
    fun getPokemons(refresh: Boolean = false): List<Pokemon>
    fun getPokemonCharacteristics(refresh: Boolean = false, pokemonId: Int): Pokemon
}