package pt.pprojects.pokelist.datasource.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonMoveResponse(
    @SerialName("move") val move: PokemonMove
)

@Serializable
data class PokemonMove(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)
