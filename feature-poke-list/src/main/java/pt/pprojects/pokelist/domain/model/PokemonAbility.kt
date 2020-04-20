package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonAbility(
    val abiltiyId: Int,
    val abilityName: String,
    val isHidden: Boolean
) : ModelInterface