package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class Pokemon(
    private val pokemonId: Int,
    private val pokemonName: String
): ModelInterface
