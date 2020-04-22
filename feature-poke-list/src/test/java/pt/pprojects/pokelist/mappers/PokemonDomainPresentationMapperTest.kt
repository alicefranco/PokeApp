package pt.pprojects.pokelist.mappers

import org.junit.Test

import pt.pprojects.pokelist.domain.model.Pokemon
import org.assertj.core.api.Assertions.assertThat
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics
import pt.pprojects.pokelist.domain.model.PokemonImages
import pt.pprojects.pokelist.domain.model.PokemonType
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.model.*

class PokemonDomainPresentationMapperTest {

    private val pokemonDomainPresentationMapper = PokemonDomainPresentationMapper()

    @Test
    fun `should return domain pokemons list`() {
        val result = pokemonDomainPresentationMapper
            .mapPokemonsToPresentation(pokemonsDomainList)

        assertThat(result).isEqualTo(expectedPokemonPresentationList)
    }

    @Test
    fun `should return empty list`() {
        val result = pokemonDomainPresentationMapper
            .mapPokemonsToPresentation(pokemonDomainEmptyList)

        assertThat(result).isEqualTo(emptyList<PokemonItem>())
    }

    @Test
    fun `should return domain pokemon characteristics`() {
        val result = pokemonDomainPresentationMapper
            .mapPokemonDetailsToPresentation(pokemonCharsDomain)

        assertThat(result).isEqualTo(expectedPokemonCharPresentation)
    }

    private val pokemonsDomainList = listOf(
        Pokemon(
            pokemonName = "Charmander",
            pokemonId = 4
        ),
        Pokemon(
            pokemonName = "Charmeleon",
            pokemonId = 5
        )
    )

    private val expectedPokemonPresentationList = listOf(
        PokemonItem(
            itemType = ListItem.LIST_ITEM,
            name = "Charmander",
            number = "4",
            image = "ic_4"
        ),
        PokemonItem(
            itemType = ListItem.LIST_ITEM,
            name = "Charmeleon",
            number = "5",
            image = "ic_5"
        )
    )

    private val pokemonDomainEmptyList = listOf<Pokemon>()

    private val pokemonCharsDomain = PokemonCharacteristics(
        pokemonId = 4,
        pokemonName = "charmander",
        baseExperience = 50,
        types = listOf(
            PokemonType(
                typeId = 1,
                typeName = "fire"
            )
        ),
        height = 5,
        weight = 15,
        moves = listOf(),
        abilities = listOf(),
        images = PokemonImages(
            pokemonId = 4,
            frontDefault = "",
            backDefault = null,
            frontFemale = null,
            backFemale = null,
            frontShiny = null,
            backShiny = null,
            frontFemaleShiny = null,
            backFemaleShiny = null
        )
    )

    private val expectedPokemonCharPresentation = PokemonDetails(
        pokemonNumber = "#4",
        pokemonName = "Charmander",
        baseExperience = "50",
        types = listOf(
            TypeItem(
                name = "FIRE",
                image = R.drawable.ic_fire
            )
        ),
        height = "0.5m",
        weight = "1.5Kg",
        moves = listOf(),
        abilities = listOf(),
        images = PokemonImagesResources(
            frontDefault = "",
            frontFemale = null,
            frontShiny = null,
            frontFemaleShiny = null
        )
    )
}
