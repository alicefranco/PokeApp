package pt.pprojects.pokelist.presentation.mapper

import kotlinx.android.synthetic.main.activity_pokelist.view.*
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.presentation.model.PokemonItem

class PokemonDomainPresentationMapper {

    fun mapPokemonsToPresentation(
        pokemons: List<Pokemon>
    ): List<PokemonItem> {
        return pokemons.map {
            PokemonItem(
                number = it.pokemonId.toString(),
                name = it.pokemonName,
                cardColor = getCardColorByGeneration(it.pokemonId),
                image = getDefaultPokemonImage(it.pokemonId)
            )
        }
    }

    private fun getCardColorByGeneration(pokemonId: Int): Int {
        return R.color.colorWhite
    }

    private fun getDefaultPokemonImage(pokemonId: Int): Int {
        return R.drawable.ic_1
    }
}