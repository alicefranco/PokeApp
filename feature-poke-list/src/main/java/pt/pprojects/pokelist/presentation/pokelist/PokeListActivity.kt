package pt.pprojects.pokelist.presentation.pokelist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pokelist.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.pprojects.domain.Result
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.PokemonItem

class PokeListActivity : AppCompatActivity() {

    private val pokeListViewModel: PokeListViewModel by viewModel()
    private lateinit var pokemonsAdapter: PokemonsAdapter
    private val layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokelist)

        setupRecycler()

        pokeListViewModel.pokemons.observe(this, Observer {
            handleResult(it)
        })

        pokeListViewModel.getPokemons(offset = 0)
    }

    private fun setupRecycler() {
        pokemonsAdapter = PokemonsAdapter()

        rv_pokemons.layoutManager = layoutManager
        rv_pokemons.adapter = pokemonsAdapter
    }

    private fun handleResult(result: Result<List<PokemonItem>>) {
        when (result) {
            is Result.Success -> {
                pokemonsAdapter.addPokemons(result.data)
                pokemonsAdapter.notifyDataSetChanged()
            }
            is Result.Loading -> {}
            is Result.Error -> {
                Log.d("ERROR", result.cause.message ?: "")
            }
        }
    }
}