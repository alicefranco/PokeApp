package pt.pprojects.pokelist.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonAbilityResponse(
    @SerializedName("ability") val ability: PokemonAbility,
    @SerializedName("is_hidden") val isHidden: Boolean
)

data class PokemonAbility(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
