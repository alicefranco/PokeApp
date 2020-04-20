package pt.pprojects.pokelist.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonTypeResponse(
    @SerialName("type") val type: PokemonType
)

@Serializable
data class PokemonType(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)