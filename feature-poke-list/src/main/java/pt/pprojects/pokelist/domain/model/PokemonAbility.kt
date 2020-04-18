package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonAbility(
    private val abiltiyId: Int,
    private val abilityName: String,
    private val isHidden: Boolean
): ModelInterface