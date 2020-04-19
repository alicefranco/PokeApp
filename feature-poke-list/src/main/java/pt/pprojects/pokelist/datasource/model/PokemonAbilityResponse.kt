package pt.pprojects.pokelist.datasource.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonAbilityResponse(
    @SerialName("ability") val ability: PokemonAbility,
    @SerialName("is_hidden") val isHidden: Boolean
)

@Serializable
data class PokemonAbility(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)
