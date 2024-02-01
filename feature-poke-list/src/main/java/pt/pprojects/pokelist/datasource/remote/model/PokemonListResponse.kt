package pt.pprojects.pokelist.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("next") val next: String? = null,
    @SerializedName("results") val pokemons: List<PokemonResponse>
)