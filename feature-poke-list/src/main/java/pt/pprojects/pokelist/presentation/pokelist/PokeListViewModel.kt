package pt.pprojects.pokelist.presentation.pokelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pt.pprojects.domain.DomainResult
import pt.pprojects.pokelist.domain.model.UiResult
import pt.pprojects.pokelist.domain.usecase.PokemonsUseCase
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.model.PokemonItem

class PokeListViewModel(
    private val pokemonsUseCase: PokemonsUseCase,
    private val pokemonMapper: PokemonDomainPresentationMapper
) : ViewModel() {

    private val PAGE_SIZE = 20
    private val START_OFFSET = 0
    private val TOTAL_POKEMONS = 984

    private var offset = START_OFFSET

    var loadedAll = false

    private val _pokemonListStateFlow = MutableStateFlow<UiResult<List<PokemonItem>>>(UiResult.Loading)
    val pokemonListStateFlow: StateFlow<UiResult<List<PokemonItem>>> = _pokemonListStateFlow

    init {
        getPokemons()
    }

    fun getPokemons(refresh: Boolean = false) {
        viewModelScope.launch {
            pokemonsUseCase.execute(refresh, offset)
                .collect { result ->
                    when (result) {
                        is DomainResult.Success -> {
                            val items = pokemonMapper.mapPokemonsToPresentation(result.data)
                            _pokemonListStateFlow.value = UiResult.Success(items)
                        }
                        is DomainResult.Error -> {
                            _pokemonListStateFlow.value = UiResult.Error(result.cause)
                        }
                    }
                }
        }
    }

    private fun updateOffset() {
        offset += PAGE_SIZE
        if (offset == TOTAL_POKEMONS)
            loadedAll = true
    }
}