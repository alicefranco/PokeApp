package pt.pprojects.pokelist.datasource.remote.model

data class PokemonMoveResponse(
    val move: PokemonMove
)

data class PokemonMove(
    val name: String,
    val url: String
)
