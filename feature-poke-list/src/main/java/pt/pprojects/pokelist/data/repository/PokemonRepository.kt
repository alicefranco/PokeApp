package pt.pprojects.pokelist.data.repository

import pt.pprojects.pokelist.data.datasource.PokemonCacheDataSourceInterface
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface

class PokemonRepository(
    private val cacheDataSource: PokemonCacheDataSourceInterface,
    private val remoteDataSource: PokemonRemoteDataSourceInterface
) : PokemonRepositoryInterface {

    override fun getPokemons(refresh: Boolean): List<Pokemon> {
        return when (refresh) {
            false -> cacheDataSource.getPokemons()
            true -> remoteDataSource.getPokemons()
        }
    }

    override fun getPokemonCharacteristics(refresh: Boolean, pokemonId: Int): Pokemon {
        return when (refresh) {
            false -> cacheDataSource.getPokemonCharacteristics(pokemonId)
            true -> remoteDataSource.getPokemonCharacteristics(pokemonId)
        }
    }
}