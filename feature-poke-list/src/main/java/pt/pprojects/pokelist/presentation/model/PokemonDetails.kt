package pt.pprojects.pokelist.presentation.model

data class PokemonDetails(
    val pokemonNumber: String,
    val pokemonName: String,
    val height: String,
    val weight: String,
    val images: PokemonImagesResources,
    val types: List<TypeItem>,
    val moves: List<MoveItem>,
    val abilities: List<AbilityItem>
)