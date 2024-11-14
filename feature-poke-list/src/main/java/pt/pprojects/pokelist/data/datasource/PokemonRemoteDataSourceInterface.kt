package pt.pprojects.pokelist.data.datasource

import kotlinx.coroutines.flow.Flow
import pt.pprojects.domain.DomainResult
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics

interface PokemonRemoteDataSourceInterface {
    suspend fun getPokemons(offset: Int): Flow<DomainResult<List<Pokemon>>>
    suspend fun getPokemonCharacteristics(pokemonId: Int): Flow<DomainResult<PokemonCharacteristics>>
}