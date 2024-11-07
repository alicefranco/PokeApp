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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.PokemonItem
import pt.pprojects.pokelist.presentation.pokemondetails.POKE_DETAILS

const val POKE_LIST = "list"

@Composable
fun PokeListScreen(navController: NavController) {
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
        //TODO - loading condition
        if (true) {
            PokeList(
                modifier = Modifier.weight(0.92f),
                listOf(
                    PokemonItem(
                        number = "#1",
                        name = "Bulbassauro",
                        image = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/4a47b50e-cf1a-4594-9276-a81dd8cb914a/dfaasvy-f73ddbaa-d4f2-4863-addf-9391cbf363bd.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzRhNDdiNTBlLWNmMWEtNDU5NC05Mjc2LWE4MWRkOGNiOTE0YVwvZGZhYXN2eS1mNzNkZGJhYS1kNGYyLTQ4NjMtYWRkZi05MzkxY2JmMzYzYmQucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.8IpIN-i91mA5kTKmI7jJQPr7r5LiTBLZSJ0mYhivmac"
                    ),
                    PokemonItem(
                        number = "#2",
                        name = "Charmander",
                        image = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/4a47b50e-cf1a-4594-9276-a81dd8cb914a/dfaasvy-f73ddbaa-d4f2-4863-addf-9391cbf363bd.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzRhNDdiNTBlLWNmMWEtNDU5NC05Mjc2LWE4MWRkOGNiOTE0YVwvZGZhYXN2eS1mNzNkZGJhYS1kNGYyLTQ4NjMtYWRkZi05MzkxY2JmMzYzYmQucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.8IpIN-i91mA5kTKmI7jJQPr7r5LiTBLZSJ0mYhivmac"
                    ),
                    PokemonItem(
                        number = "#3",
                        name = "Squirtle",
                        image = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/4a47b50e-cf1a-4594-9276-a81dd8cb914a/dfaasvy-f73ddbaa-d4f2-4863-addf-9391cbf363bd.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzRhNDdiNTBlLWNmMWEtNDU5NC05Mjc2LWE4MWRkOGNiOTE0YVwvZGZhYXN2eS1mNzNkZGJhYS1kNGYyLTQ4NjMtYWRkZi05MzkxY2JmMzYzYmQucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.8IpIN-i91mA5kTKmI7jJQPr7r5LiTBLZSJ0mYhivmac"
                    )
                ),
                onItemClick = {
                    pokemonItemClick(navController, "1")
                }
            )
        } else {
            CircularProgress(
                Modifier
                    .weight(0.92f)
                    .fillMaxWidth()
            )
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
//
//    private fun getPokemons() {
//        pokeListViewModel.getPokemons()
//    }
//