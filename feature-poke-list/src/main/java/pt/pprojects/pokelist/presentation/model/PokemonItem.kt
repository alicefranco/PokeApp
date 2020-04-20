package pt.pprojects.pokelist.presentation.model

data class PokemonItem(
    override var itemType: String = "POKEMON_ITEM",
    var number: String,
    var name: String,
    var image: Int,
    var cardColor: Int
) : ListItem(itemType)