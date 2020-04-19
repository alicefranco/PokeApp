package pt.pprojects.pokelist.datasource.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpriteResponse(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("front_female") val frontFemale: String,
    @SerialName("back_default") val backDefault: String,
    @SerialName("back_female") val backFemale: String,
    @SerialName("front_shiny") val frontShiny: String,
    @SerialName("front_shiny_female") val frontFemaleShiny: String,
    @SerialName("back_shiny") val backShiny: String,
    @SerialName("back_shiny_female") val backFemaleShiny: String
)
