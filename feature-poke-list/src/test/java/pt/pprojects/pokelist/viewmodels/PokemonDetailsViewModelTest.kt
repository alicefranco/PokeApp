package pt.pprojects.pokelist.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnit
import pt.pprojects.domain.Result
import pt.pprojects.network.error.NetworkingError
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.domain.model.PokemonCharacteristics
import pt.pprojects.pokelist.domain.model.PokemonImages
import pt.pprojects.pokelist.domain.model.PokemonType
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface
import pt.pprojects.pokelist.domain.usecase.PokemonCharacteristicsUseCase
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.model.PokemonDetails
import pt.pprojects.pokelist.presentation.model.PokemonImagesResources
import pt.pprojects.pokelist.presentation.model.TypeItem
import pt.pprojects.pokelist.presentation.pokemondetails.PokemonDetailsViewModel

class PokemonDetailsViewModelTest {
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val pokemonRepository: PokemonRepositoryInterface =
        mock(PokemonRepositoryInterface::class.java)

    private lateinit var pokemonCharsUsecases: PokemonCharacteristicsUseCase
    private lateinit var pokemonDetailsViewModel: PokemonDetailsViewModel
    private val pokemonDomainPresentationMapper = PokemonDomainPresentationMapper()

    @Before
    fun `before each test`() {
        pokemonCharsUsecases = PokemonCharacteristicsUseCase(pokemonRepository)

        pokemonDetailsViewModel = PokemonDetailsViewModel(
            Schedulers.trampoline(),
            pokemonCharsUsecases,
            pokemonDomainPresentationMapper
        )
    }

    @Test
    fun `get pokemon characteristics should return pokemon characteristics`() {
        `when`(
            pokemonRepository
                .getPokemonCharacteristics(false, pokemonCharsDomain.pokemonId)
        ).thenReturn(Single.just(pokemonCharsDomain))

        pokemonDetailsViewModel.getPokemonDetails(pokemonCharsDomain.pokemonId)

        assertThat(pokemonDetailsViewModel.pokemonDetails.value)
            .isEqualTo(
                Result.Success(
                    expectedPokemonCharsPresentation
                )
            )
    }

    @Test
    fun `get pokemon characteristics should return error`() {
        `when`(
            pokemonRepository
                .getPokemonCharacteristics(false, pokemonCharsDomain.pokemonId)
        ).thenReturn(Single.error(NetworkingError.ConnectionTimeout))

        pokemonDetailsViewModel.getPokemonDetails(pokemonCharsDomain.pokemonId)

        assertThat(pokemonDetailsViewModel.pokemonDetails.value)
            .isEqualToComparingFieldByField(
                Result.Error(
                    NetworkingError.ConnectionTimeout
                )
            )
    }

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

    private val expectedPokemonCharsPresentation = PokemonDetails(
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