package pt.pprojects.pokelist.datasource.remote.service

import retrofit2.http.GET
import retrofit2.http.Query
import kotlinx.coroutines.flow.Flow
import pt.pprojects.pokelist.datasource.remote.model.PokemonCharacteristicsResponse
import pt.pprojects.pokelist.datasource.remote.model.PokemonListResponse
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/")
    fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Flow<PokemonListResponse>

    @GET("pokemon/{pokemonId}")
    fun getPokemonCharacteristics(
        @Path("pokemonId") pokemonId: Int
    ): Flow<PokemonCharacteristicsResponse>
}