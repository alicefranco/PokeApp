package pt.pprojects.pokelist.domain.repository

import kotlinx.coroutines.flow.Flow
import pt.pprojects.domain.DomainResult
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics

interface PokemonRepositoryInterface {
    suspend fun getPokemons(refresh: Boolean = false, offset: Int): Flow<DomainResult<List<Pokemon>>>
    suspend fun getPokemonCharacteristics(refresh: Boolean = false, pokemonId: Int): Flow<DomainResult<PokemonCharacteristics>>
}