package pt.pprojects.pokelist.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpriteResponse(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String? = null,
    @SerialName("back_default") val backDefault: String? = null,
    @SerialName("back_female") val backFemale: String? = null,
    @SerialName("front_shiny") val frontShiny: String? = null,
    @SerialName("front_shiny_female") val frontFemaleShiny: String? = null,
    @SerialName("back_shiny") val backShiny: String? = null,
    @SerialName("back_shiny_female") val backFemaleShiny: String? = null
)
