package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonMove(
    private val moveId: Int,
    private val moveName: String
) : ModelInterface