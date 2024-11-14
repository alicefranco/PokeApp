package pt.pprojects.pokelist.datasource.remote.service

import retrofit2.http.GET
import retrofit2.http.Query
import pt.pprojects.pokelist.datasource.remote.model.PokemonCharacteristicsResponse
import pt.pprojects.pokelist.datasource.remote.model.PokemonListResponse
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonListResponse

    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonCharacteristics(
        @Path("pokemonId") pokemonId: Int
    ): PokemonCharacteristicsResponse
}