package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonType(
    val typeId: Int,
    val typeName: String
) : ModelInterface