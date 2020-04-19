package pt.pprojects.pokelist.presentation.pokelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.pprojects.domain.Result
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.domain.model.Pokemon

class PokeListActivity : AppCompatActivity() {

    private val pokeListViewModel: PokeListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokelist)

        pokeListViewModel.pokemons.observe(this, Observer {
            handleResult(it)
        })

        pokeListViewModel.getPokemons(offset = 0)
    }

    private fun handleResult(result: Result<List<Pokemon>>) {
        when (result) {
            is Result.Success -> {}
            is Result.Loading -> {}
            is Result.Error -> {}
        }
    }
}