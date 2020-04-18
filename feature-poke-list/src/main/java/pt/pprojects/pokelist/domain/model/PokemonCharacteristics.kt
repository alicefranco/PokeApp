package pt.pprojects.pokelist.domain.model

import pt.pprojects.domain.ModelInterface

data class PokemonCharacteristics(
    private val pokemonId: Int,
    private val pokemonName: String,
    private val type: List<PokemonType>,
    private val images: PokemonImages,
    private val height: Int,
    private val weight: Int,
    private val abilities: List<PokemonAbility>,
    private val moves: List<PokemonMove>
) : ModelInterface