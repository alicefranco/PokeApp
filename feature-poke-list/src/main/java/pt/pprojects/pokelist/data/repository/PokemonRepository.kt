package pt.pprojects.pokelist.data.repository

import kotlinx.coroutines.flow.Flow
import pt.pprojects.domain.DomainResult
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface

class PokemonRepository(
    // private val cacheDataSource: PokemonCacheDataSourceInterface,
    private val remoteDataSource: PokemonRemoteDataSourceInterface
) : PokemonRepositoryInterface {

    override suspend fun getPokemons(refresh: Boolean, offset: Int): Flow<DomainResult<List<Pokemon>>> {
//        return when (refresh) {
//            false -> cacheDataSource.getPokemons()
//            true -> remoteDataSource.getPokemons(offset)
//        }
        return remoteDataSource.getPokemons(offset)
    }

    override suspend fun getPokemonCharacteristics(refresh: Boolean, pokemonId: Int): Flow<DomainResult<PokemonCharacteristics>> {
//        return when (refresh) {
//            false -> cacheDataSource.getPokemonCharacteristics(pokemonId)
//            true -> remoteDataSource.getPokemonCharacteristics(pokemonId)
//        }
        return remoteDataSource.getPokemonCharacteristics(pokemonId)
    }
}