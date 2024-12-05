package pt.pprojects.pokelist.presentation.pokemondetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pt.pprojects.domain.DomainResult
import pt.pprojects.pokelist.domain.model.UiResult
import pt.pprojects.pokelist.domain.usecase.PokemonCharacteristicsUseCase
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.model.PokemonDetails
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonCharacteristicsUseCase: PokemonCharacteristicsUseCase,
    private val pokemonMapper: PokemonDomainPresentationMapper
) : ViewModel() {

    private val _pokemonDetailsStateFlow = MutableStateFlow<UiResult<PokemonDetails>>(UiResult.Loading)
    val pokemonDetailsStateFlow: StateFlow<UiResult<PokemonDetails>> = _pokemonDetailsStateFlow

    fun getPokemonDetails(pokemonId: Int) {
        viewModelScope.launch {
            _pokemonDetailsStateFlow.value = UiResult.Loading
            pokemonCharacteristicsUseCase.execute(refresh = false, params = pokemonId)
                .collect { result ->
                    when (result) {
                        is DomainResult.Success -> {
                            val item = pokemonMapper.mapPokemonDetailsToPresentation(result.data)
                            _pokemonDetailsStateFlow.value = UiResult.Success(item)
                        }
                        is DomainResult.Error -> {
                            _pokemonDetailsStateFlow.value = UiResult.Error(result.cause)
                        }
                    }
                }
        }
    }
}
