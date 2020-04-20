package pt.pprojects.pokelist.presentation.mapper

import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.domain.model.*
import pt.pprojects.pokelist.presentation.model.*

class PokemonDomainPresentationMapper {

    companion object {
        const val FIRE_TYPE = "fire"
        const val WATER_TYPE = "water"
        const val GRASS_TYPE = "grass"
        const val ELECTRIC_TYPE = "electric"
        const val ICE_TYPE = "ice"
        const val FAIRY_TYPE = "fairy"
        const val NORMAL_TYPE = "normal"
        const val PSYCHIC_TYPE = "psychic"
        const val DARK_TYPE = "dark"
        const val GHOST_TYPE = "ghost"
        const val POISON_TYPE = "poison"
        const val BUG_TYPE = "bug"
        const val FLYING_TYPE = "flying"
        const val DRAGON_TYPE = "dragon"
        const val FIGHTING_TYPE = "fighting"
        const val GROUND_TYPE = "ground"
        const val ROCK_TYPE = "rock"
        const val STEEL_TYPE = "steel"
    }

    fun mapPokemonsToPresentation(
        pokemons: List<Pokemon>
    ): List<PokemonItem> {
        return pokemons.map {
            PokemonItem(
                itemType = ListItem.LIST_ITEM,
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

    fun mapPokemonDetailsToPresentation(
        pokemonDetails: PokemonCharacteristics
    ): PokemonDetails {
        return PokemonDetails(
            pokemonName = pokemonDetails.pokemonName,
            pokemonNumber = pokemonDetails.pokemonId.toString(),
            height = pokemonDetails.height.toString(),
            weight = pokemonDetails.weight.toString(),
            images = getImageResources(pokemonDetails.images),
            types = getTypes(pokemonDetails.type),
            moves = getMoves(pokemonDetails.moves),
            abilities = getAbilities(pokemonDetails.abilities)
        )
    }

    private fun getTypes(types: List<PokemonType>): List<TypeItem> {
        val typesList: ArrayList<TypeItem> = arrayListOf()
        types.forEach {
            typesList.add(
                TypeItem(
                    it.typeName,
                    image = getTypeImage(it.typeName)
                )
            )
        }
        return typesList
    }

    private fun getAbilities(abilities: List<PokemonAbility>): List<AbilityItem> {
        val abilitiesList: ArrayList<AbilityItem> = arrayListOf()
        abilities.forEach {
            abilitiesList.add(
                AbilityItem(
                    name = it.abilityName,
                    isHidden = it.isHidden
                )
            )
        }
        return abilitiesList
    }

    private fun getMoves(moves: List<PokemonMove>): List<MoveItem> {
        val movesList: ArrayList<MoveItem> = arrayListOf()
        moves.forEach {
            movesList.add(
                MoveItem(name = it.moveName)
            )
        }
        return movesList
    }

    private fun getImageResources(
        images: PokemonImages
    ): PokemonImagesResources {
        return PokemonImagesResources(
            frontDefault = images.frontDefault,
            backDefault = images.frontDefault,
            frontFemale = images.frontDefault,
            backFemale = images.frontDefault
        )
    }

    private fun getTypeImage(type: String): Int {
        var imageResource = R.drawable.ic_fire
        when (type) {
            FIRE_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            WATER_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            GRASS_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            ELECTRIC_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            ICE_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            FAIRY_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            NORMAL_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            PSYCHIC_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            DARK_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            GHOST_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            POISON_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            BUG_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            FLYING_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            DRAGON_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            FIGHTING_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            GROUND_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            ROCK_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
            STEEL_TYPE -> {
                imageResource = R.drawable.ic_fire
            }
        }
        return imageResource
    }
}