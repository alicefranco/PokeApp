package pt.pprojects.pokelist.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonMoveResponse(
    @SerializedName("move") val move: PokemonMove
)

data class PokemonMove(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
