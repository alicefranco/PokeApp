package pt.pprojects.pokelist.presentation.pokelist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pokelist.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.pprojects.domain.Result
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.gone
import pt.pprojects.pokelist.presentation.model.PokemonItem
import pt.pprojects.pokelist.presentation.pokemondetails.PokemonDetailsActivity
import pt.pprojects.pokelist.presentation.showDialog
import pt.pprojects.pokelist.presentation.visible

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

        getPokemons()
    }

    private fun setupRecycler() {
        pokemonsAdapter = PokemonsAdapter(this)
        pokemonsAdapter.addPokemonItemClick(pokemonItemClick)
        pokemonsAdapter.addLoadMoreAction(loadMoreAction)

        rv_pokemons.layoutManager = layoutManager
        rv_pokemons.adapter = pokemonsAdapter
    }

    private fun handleResult(result: Result<List<PokemonItem>>) {
        when (result) {
            is Result.Success -> {
                pb_list_loading.gone()
                rv_pokemons.visible()
                pokemonsAdapter.addPokemons(result.data, pokeListViewModel.loadedAll)
                pokemonsAdapter.notifyDataSetChanged()
            }
            is Result.Loading -> {
            }
            is Result.Error -> {
                showErrorDialog(getString(R.string.error_title), result.cause.message)
            }
        }
    }

    private fun showErrorDialog(
        title: String,
        message: String?
    ) {
        this.showDialog(
            title,
            message,
            positiveAction = {
                getPokemons()
            },
            negativeAction = {
                finish()
            }
        )
    }

    private fun getPokemons() {
        pokeListViewModel.getPokemons()
    }

    private val pokemonItemClick: (pokemonId: Int) -> Unit = { pokemonId ->
        openPokemonDetailsScreen(pokemonId)
    }

    private val loadMoreAction: () -> Unit = {
        pokeListViewModel.getPokemons(false)
    }

    private fun openPokemonDetailsScreen(pokemonId: Int) {
        val intent = Intent(this, PokemonDetailsActivity::class.java)
        intent.putExtra(POKEMON_ID, pokemonId)
        startActivity(intent)
    }

    companion object {
        const val POKEMON_ID = "POKEMON_ID"
    }
}