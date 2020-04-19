package pt.pprojects.pokelist.datasource.remote.service

import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.Single
import pt.pprojects.pokelist.datasource.model.PokemonCharacteristicsResponse
import pt.pprojects.pokelist.datasource.model.PokemonResponse
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/")
    fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Single<List<PokemonResponse>>

    @GET("pokemon/{pokemonId}")
    fun getPokemonCharacteristics(
        @Path("pokemonId") pokemonId: Int
    ): Single<PokemonCharacteristicsResponse>
}