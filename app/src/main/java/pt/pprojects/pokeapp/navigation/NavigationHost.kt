package pt.pprojects.pokeapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.pprojects.pokelist.presentation.pokelist.POKE_LIST
import pt.pprojects.pokelist.presentation.pokelist.PokeListScreen
import pt.pprojects.pokelist.presentation.pokelist.PokeListViewModel
import pt.pprojects.pokelist.presentation.pokemondetails.POKE_DETAILS
import pt.pprojects.pokelist.presentation.pokemondetails.PokemonDetailScreen
import pt.pprojects.pokelist.presentation.pokemondetails.PokemonDetailsViewModel

@Composable
fun NavigationHost(navController: NavHostController) {
    val pokeListViewModel: PokeListViewModel = hiltViewModel()
    val pokeDetailsViewModel: PokemonDetailsViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = POKE_LIST) {
        composable(POKE_LIST) { PokeListScreen(navController, pokeListViewModel) }
        composable(
            "$POKE_DETAILS/{pokemonId}"
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId")
            pokemonId?.let {
                PokemonDetailScreen(it, pokeDetailsViewModel) { navController.popBackStack() }
            }
        }
    }
}

