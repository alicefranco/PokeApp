package pt.pprojects.pokelist.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonTypeResponse(
    @SerializedName("type") val type: PokemonType
)

data class PokemonType(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)