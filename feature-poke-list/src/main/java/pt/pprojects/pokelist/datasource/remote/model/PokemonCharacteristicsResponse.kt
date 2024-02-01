package pt.pprojects.pokelist.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonCharacteristicsResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("base_experience") val baseExperience: Int,
    @SerializedName("types") val types: List<PokemonTypeResponse>,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("moves") val moves: List<PokemonMoveResponse>,
    @SerializedName("abilities") val abilities: List<PokemonAbilityResponse>,
    @SerializedName("sprites") val sprites: PokemonSpriteResponse
)