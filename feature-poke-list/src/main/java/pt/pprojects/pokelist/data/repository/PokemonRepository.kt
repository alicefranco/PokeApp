package pt.pprojects.pokelist.data.repository

import io.reactivex.rxjava3.core.Single
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface

class PokemonRepository(
    // private val cacheDataSource: PokemonCacheDataSourceInterface,
    private val remoteDataSource: PokemonRemoteDataSourceInterface
) : PokemonRepositoryInterface {

    override fun getPokemons(refresh: Boolean, offset: Int): Single<List<Pokemon>> {
//        return when (refresh) {
//            false -> cacheDataSource.getPokemons()
//            true -> remoteDataSource.getPokemons(offset)
//        }
        return remoteDataSource.getPokemons(offset)
    }

    override fun getPokemonCharacteristics(refresh: Boolean, pokemonId: Int): Single<PokemonCharacteristics> {
//        return when (refresh) {
//            false -> cacheDataSource.getPokemonCharacteristics(pokemonId)
//            true -> remoteDataSource.getPokemonCharacteristics(pokemonId)
//        }
        return remoteDataSource.getPokemonCharacteristics(pokemonId)
    }
}