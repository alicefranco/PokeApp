package pt.pprojects.pokelist.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCharacteristicsResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("types") val types: List<PokemonTypeResponse>,
    @SerialName("height") val height: Int,
    @SerialName("weight") val weight: Int,
    @SerialName("moves") val moves: List<PokemonMoveResponse>,
    @SerialName("abilities") val abilities: List<PokemonAbilityResponse>,
    @SerialName("sprites") val sprites: PokemonSpriteResponse
)