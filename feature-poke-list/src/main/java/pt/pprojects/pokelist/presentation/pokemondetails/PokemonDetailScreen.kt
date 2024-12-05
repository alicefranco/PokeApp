package pt.pprojects.pokelist.presentation.pokemondetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.domain.model.UiResult
import pt.pprojects.pokelist.presentation.CircularProgress


const val POKE_DETAILS = "details"
@Composable
fun PokemonDetailScreen(
    pokemonId: String,
    viewModel: PokemonDetailsViewModel,
    onCloseDetails: () -> Unit
) {
    val pokemonDetails by viewModel
        .pokemonDetailsStateFlow
        .collectAsStateWithLifecycle(initialValue = UiResult.Loading)

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.colorPrimary))
            .verticalScroll(rememberScrollState()),
    ) {
        when (pokemonDetails) {
            is UiResult.Success -> {
                (pokemonDetails as? UiResult.Success)?.let { pokemon ->
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .padding(16.dp)

                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                        ) {
                            PokemonDetail(pokemon.data, onCloseDetails)
                        }
                    }
                }
            }
            is UiResult.Loading -> {
                viewModel.getPokemonDetails(pokemonId.toInt())
                CircularProgress(
                    Modifier
                        .fillMaxWidth()
                )
            }
            is UiResult.Error -> {}
        }
    }
}
