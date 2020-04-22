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
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.repository.PokemonRepositoryInterface
import pt.pprojects.pokelist.domain.usecase.PokemonsUseCase
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.model.ListItem
import pt.pprojects.pokelist.presentation.model.PokemonItem
import pt.pprojects.pokelist.presentation.pokelist.PokeListViewModel

class PokeListViewModelTest {
    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val pokemonRepository: PokemonRepositoryInterface =
        mock(PokemonRepositoryInterface::class.java)

    private lateinit var pokeListUsecases: PokemonsUseCase
    private lateinit var pokeListViewModel: PokeListViewModel
    private val pokemonDomainPresentationMapper = PokemonDomainPresentationMapper()

    @Before
    fun `before each test`() {
        pokeListUsecases = PokemonsUseCase(pokemonRepository)

        pokeListViewModel = PokeListViewModel(
            Schedulers.trampoline(),
            pokeListUsecases,
            pokemonDomainPresentationMapper
        )
    }

    @Test
    fun `get pokemons should return pokemons`() {
        `when`(pokemonRepository.getPokemons(false, 0)).thenReturn(Single.just(pokemonsDomain))
        pokeListViewModel.getPokemons(false)

        assertThat(pokeListViewModel.pokemons.value).isEqualTo(
            Result.Success(
                expectedPokemonPresentation
            )
        )
    }

    @Test
    fun `get pokemons should return error`() {
        `when`(
            pokemonRepository.getPokemons(
                false,
                0
            )
        ).thenReturn(Single.error(NetworkingError.ConnectionTimeout))
        pokeListViewModel.getPokemons(false)

        assertThat(pokeListViewModel.pokemons.value).isEqualToComparingFieldByField(
            Result.Error(
                NetworkingError.ConnectionTimeout
            )
        )
    }

    private val pokemonsDomain = listOf(
        Pokemon(
            pokemonName = "Charmander",
            pokemonId = 4
        ),
        Pokemon(
            pokemonName = "Charmeleon",
            pokemonId = 5
        )
    )

    private val expectedPokemonPresentation = listOf(
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
}
