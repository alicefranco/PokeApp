package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonCharacteristics(
    val pokemonId: Int,
    val pokemonName: String,
    val type: List<PokemonType>,
    val images: PokemonImages,
    val height: Int,
    val weight: Int,
    val abilities: List<PokemonAbility>,
    val moves: List<PokemonMove>
) : ModelInterface