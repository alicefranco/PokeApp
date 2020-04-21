package pt.pprojects.pokelist.presentation.model

data class TypeItem(
    val name: String,
    val image: Int
) : DetailItem(name)