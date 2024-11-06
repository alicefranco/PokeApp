package pt.pprojects.pokeapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.pprojects.pokelist.presentation.pokelist.PokeListScreen
import pt.pprojects.pokelist.presentation.pokelist.PokeListViewModel

class SplashActivity : AppCompatActivity() {

    private val pokeListViewModel: PokeListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                MaterialTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        PokeListScreen(pokeListViewModel)
                }
            }
        }
    }
}
