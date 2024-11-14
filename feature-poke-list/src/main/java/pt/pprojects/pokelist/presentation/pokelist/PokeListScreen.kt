package pt.pprojects.pokelist.presentation.pokelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.domain.model.UiResult
import pt.pprojects.pokelist.presentation.pokemondetails.POKE_DETAILS

const val POKE_LIST = "list"

@Composable
fun PokeListScreen(navController: NavController, viewModel: PokeListViewModel) {
    val pokeList by viewModel
        .pokemonListStateFlow
        .collectAsStateWithLifecycle(initialValue = UiResult.Loading)

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.colorPrimary))
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .weight(0.08f),
            painter = painterResource(id = R.drawable.logo_pokeapp),
            contentScale = ContentScale.Fit,
            contentDescription = "Logo",
        )
        when (pokeList) {
            is UiResult.Success -> {
                (pokeList as? UiResult.Success)?.let { pokeList ->
                    PokeList(
                        modifier = Modifier.weight(0.92f),
                        pokemons = pokeList.data,
                        onItemClick = {
                            pokemonItemClick(navController, "1")
                        }
                    )
                }
            }

            is UiResult.Loading -> {
                CircularProgress(
                    Modifier
                        .weight(0.92f)
                        .fillMaxWidth()
                )
            }

            is UiResult.Error -> {}
        }
    }
}

@Composable
private fun CircularProgress(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(48.dp),
            strokeWidth = 4.dp,
            color = colorResource(id = R.color.colorAccent)
        )
    }
}

private val pokemonItemClick: (navController: NavController, pokemonId: String) -> Unit = { navController, pokemonId ->
    navController.navigate("${POKE_DETAILS}/${pokemonId}")
}

//    private fun handleResult(result: Result<List<PokemonItem>>) {
//        when (result) {
//            is Result.Success -> {
//                binding.pbListLoading.gone()
//                binding.rvPokemons.visible()
//                pokemonsAdapter.addPokemons(result.data, pokeListViewModel.loadedAll)
//                pokemonsAdapter.notifyDataSetChanged()
//            }
//            is Result.Loading -> {
//            }
//            is Result.Error -> {
//                showErrorDialog(getString(R.string.error_title), result.cause.message)
//            }
//        }
//    }
//
//    private fun showErrorDialog(
//        title: String,
//        message: String?
//    ) {
//        this.showDialog(
//            title,
//            message + getString(R.string.error_reload_message),
//            positiveAction = {
//                getPokemons()
//            },
//            negativeAction = {
//                finish()
//            }
//        )
//    }