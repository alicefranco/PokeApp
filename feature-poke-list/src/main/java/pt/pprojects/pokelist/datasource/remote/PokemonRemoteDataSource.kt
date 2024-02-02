package pt.pprojects.pokelist.datasource.remote

import io.reactivex.rxjava3.core.Single
import pt.pprojects.network.manager.NetworkManagerInterface
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.datasource.remote.mapper.PokemonRemoteDomainMapper
import pt.pprojects.pokelist.datasource.remote.service.PokemonService
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics

class PokemonRemoteDataSource(
    private val networkManager: NetworkManagerInterface,
    private val pokemonService: PokemonService,
    private val pokemonMapper: PokemonRemoteDomainMapper
) : PokemonRemoteDataSourceInterface {
    override fun getPokemons(offset: Int): Single<List<Pokemon>> {
        return networkManager.performAndReturnsData(
            pokemonService
                .getPokemons(offset, limit)
                .map {
                    pokemonMapper.mapPokemonsToDomain(it.results)
                }
        )
    }

    override fun getPokemonCharacteristics(pokemonId: Int): Single<PokemonCharacteristics> {
        return networkManager.performAndReturnsData(
            pokemonService
                .getPokemonCharacteristics(pokemonId)
                .map {
                    pokemonMapper.mapPokemonCharacteristicsToDomain(it)
                }
        )
    }

    companion object {
        const val limit = 20
    }
}