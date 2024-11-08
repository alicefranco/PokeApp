package pt.pprojects.pokeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.pprojects.pokelist.presentation.pokelist.POKE_LIST
import pt.pprojects.pokelist.presentation.pokelist.PokeListScreen
import pt.pprojects.pokelist.presentation.pokemondetails.POKE_DETAILS
import pt.pprojects.pokelist.presentation.pokemondetails.PokemonDetailScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = POKE_LIST) {
        composable(POKE_LIST) { PokeListScreen(navController = navController) }
        composable(
            "$POKE_DETAILS/{pokemonId}"
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("itemId")
            pokemonId?.let {
                PokemonDetailScreen(it)
            }
        }
    }
}

