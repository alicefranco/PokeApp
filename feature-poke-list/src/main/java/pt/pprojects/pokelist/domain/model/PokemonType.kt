package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonType(
    private val typeId: Int,
    private val typeName: String
) : ModelInterface