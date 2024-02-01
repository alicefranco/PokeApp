package pt.pprojects.pokelist.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class PokemonSpriteResponse(
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("front_female") val frontFemale: String? = null,
    @SerializedName("back_default") val backDefault: String? = null,
    @SerializedName("back_female") val backFemale: String? = null,
    @SerializedName("front_shiny") val frontShiny: String? = null,
    @SerializedName("front_shiny_female") val frontFemaleShiny: String? = null,
    @SerializedName("back_shiny") val backShiny: String? = null,
    @SerializedName("back_shiny_female") val backFemaleShiny: String? = null
)
