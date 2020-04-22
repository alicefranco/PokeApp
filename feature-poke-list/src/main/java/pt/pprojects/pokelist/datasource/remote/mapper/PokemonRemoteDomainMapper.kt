package pt.pprojects.pokelist.datasource.remote.mapper

import pt.pprojects.pokelist.datasource.remote.model.*
import pt.pprojects.pokelist.domain.model.*
import pt.pprojects.pokelist.domain.model.PokemonAbility
import pt.pprojects.pokelist.domain.model.PokemonMove
import pt.pprojects.pokelist.domain.model.PokemonType

class PokemonRemoteDomainMapper {
    companion object {
        const val POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/"
        const val TYPE_URL = "https://pokeapi.co/api/v2/type/"
        const val ABILITY_URL = "https://pokeapi.co/api/v2/ability/"
        const val MOVE_URL = "https://pokeapi.co/api/v2/move/"
    }

    fun mapPokemonsToDomain(
        pokemonsResponse: List<PokemonResponse>
    ): List<Pokemon> {
        return pokemonsResponse.map {
            Pokemon(
                pokemonId = getId(it.url, POKEMON_URL),
                pokemonName = it.name
            )
        }
    }

    fun mapPokemonCharacteristicsToDomain(
        pokemonCharacteristicsResponse: PokemonCharacteristicsResponse
    ): PokemonCharacteristics {
        val pokemon = pokemonCharacteristicsResponse
        return PokemonCharacteristics(
            pokemonId = pokemon.id,
            pokemonName = pokemon.name,
            baseExperience = pokemon.baseExperience,
            types = getPokemonTypes(pokemon.types),
            images = getPokemonImages(
                pokemonId = pokemon.id,
                sprites = pokemon.sprites
            ),
            height = pokemon.height,
            weight = pokemon.weight,
            abilities = getPokemonAbilities(pokemon.abilities),
            moves = getPokemonMoves(pokemon.moves)
        )
    }

    private fun getPokemonImages(
        pokemonId: Int,
        sprites: PokemonSpriteResponse
    ) = PokemonImages(
        pokemonId = pokemonId,
        frontDefault = sprites.frontDefault,
        backDefault = sprites.backDefault,
        frontFemale = sprites.frontFemale,
        backFemale = sprites.backFemale,
        frontShiny = sprites.frontShiny,
        backShiny = sprites.backShiny,
        frontFemaleShiny = sprites.frontFemaleShiny,
        backFemaleShiny = sprites.backFemaleShiny
    )

    private fun getPokemonTypes(
        types: List<PokemonTypeResponse>
    ): List<PokemonType> {
        val typesList = arrayListOf<PokemonType>()
        types.forEach { it ->
            typesList.add(
                PokemonType(
                    typeId = getId(it.type.url, TYPE_URL),
                    typeName = it.type.name
                )
            )
        }
        return typesList
    }

    private fun getPokemonAbilities(
        abilities: List<PokemonAbilityResponse>
    ): List<PokemonAbility> {
        val abilitiesList = arrayListOf<PokemonAbility>()
        abilities.forEach { it ->
            abilitiesList.add(
                PokemonAbility(
                    abiltiyId = getId(it.ability.url, ABILITY_URL),
                    abilityName = it.ability.name,
                    isHidden = it.isHidden
                )
            )
        }
        return abilitiesList
    }
    private fun getPokemonMoves(
        abilities: List<PokemonMoveResponse>
    ): List<PokemonMove> {
        val movesList = arrayListOf<PokemonMove>()
        abilities.forEach { it ->
            movesList.add(
                PokemonMove(
                    moveId = getId(it.move.url, MOVE_URL),
                    moveName = it.move.name
                )
            )
        }
        return movesList
    }

    private fun getId(
        url: String,
        urlBase: String
    ): Int {
        val numberOfCharsToDrop = urlBase.length
        if (url.last() == '/') {
            return url.drop(numberOfCharsToDrop)
                .dropLast(1)
                .toInt()
        } else {
            return url.drop(numberOfCharsToDrop)
                .toInt()
        }
    }
}