package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonImages(
    private val pokemonId: Int,
    private val frontDefault: String,
    private val backDefault: String,
    private val frontFemale: String,
    private val backFemale: String,
    private val frontShiny: String,
    private val backShiny: String,
    private val frontFemaleShiny: String,
    private val backFemaleShiny: String
): ModelInterface