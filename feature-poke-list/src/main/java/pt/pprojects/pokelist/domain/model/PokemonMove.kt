package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonMove(
    val moveId: Int,
    val moveName: String
) : ModelInterface