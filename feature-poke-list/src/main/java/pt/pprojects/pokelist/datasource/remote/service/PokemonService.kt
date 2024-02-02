package pt.pprojects.pokelist.datasource.remote.service

import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.rxjava3.core.Single
import pt.pprojects.pokelist.datasource.remote.model.PokemonCharacteristicsResponse
import pt.pprojects.pokelist.datasource.remote.model.PokemonListResponse
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/")
    fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Single<PokemonListResponse>

    @GET("pokemon/{pokemonId}")
    fun getPokemonCharacteristics(
        @Path("pokemonId") pokemonId: Int
    ): Single<PokemonCharacteristicsResponse>
}