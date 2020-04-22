package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class Pokemon(
    val pokemonId: Int,
    val pokemonName: String
) : ModelInterface
