package pt.pprojects.pokelist.datasource.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pt.pprojects.domain.DomainResult
import pt.pprojects.network.NetworkResult
import pt.pprojects.network.manager.NetworkManagerInterface
import pt.pprojects.pokelist.data.datasource.PokemonRemoteDataSourceInterface
import pt.pprojects.pokelist.datasource.remote.mapper.PokemonRemoteDomainMapper
import pt.pprojects.pokelist.datasource.remote.service.PokemonService
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(
    private val networkManager: NetworkManagerInterface,
    private val pokemonService: PokemonService,
    private val pokemonMapper: PokemonRemoteDomainMapper
) : PokemonRemoteDataSourceInterface {
    override suspend fun getPokemons(offset: Int): Flow<DomainResult<List<Pokemon>>> {
        return flow {
            networkManager
                .performAndReturnsData(
                    pokemonService.getPokemons(offset, LIMIT)
                ).collect {
                    when (it) {
                        is NetworkResult.Success -> {
                            val results = pokemonMapper.mapPokemonsToDomain(it.data.results)
                            emit(DomainResult.Success(results))
                        }
                        is NetworkResult.Error -> emit(DomainResult.Error(it.cause))
                    }
                }
        }
    }

    override suspend fun getPokemonCharacteristics(pokemonId: Int): Flow<DomainResult<PokemonCharacteristics>> {
        return flow {
            networkManager.performAndReturnsData(
                pokemonService.getPokemonCharacteristics(pokemonId)
            ).collect {
                when (it) {
                    is NetworkResult.Success -> {
                        val result = pokemonMapper.mapPokemonCharacteristicsToDomain(it.data)
                        emit(DomainResult.Success(result))
                    }
                    is NetworkResult.Error -> emit(DomainResult.Error(it.cause))
                }
            }
        }
    }

    companion object {
        const val LIMIT = 20
    }
}