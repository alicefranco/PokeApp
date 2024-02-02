package pt.pprojects.pokelist.datasource.remote.model

data class PokemonTypeResponse(
    val type: PokemonType
)

data class PokemonType(
    val name: String,
    val url: String
)