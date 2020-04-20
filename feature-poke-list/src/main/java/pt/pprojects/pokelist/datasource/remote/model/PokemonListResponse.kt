package pt.pprojects.pokelist.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    @SerialName("count") val count: Int,
    @SerialName("previous") val previous: String? = null,
    @SerialName("next") val next: String? = null,
    @SerialName("results") val pokemons: List<PokemonResponse>
)