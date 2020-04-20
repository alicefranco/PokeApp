package pt.pprojects.pokelist.presentation.pokemondetails

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.pprojects.domain.Result
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.PokemonDetails
import pt.pprojects.pokelist.presentation.pokelist.PokeListActivity
import pt.pprojects.pokelist.presentation.gone
import pt.pprojects.pokelist.presentation.visible

class PokemonDetailsActivity : AppCompatActivity() {
    private val pokemonDetailsViewModel: PokemonDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemonId = intent.getIntExtra(PokeListActivity.POKEMON_ID, 1)

        iv_close.setOnClickListener {
            closePokemonDetailsScreen()
        }

        pokemonDetailsViewModel.getPokemonDetails(pokemonId)

        pokemonDetailsViewModel.pokemonDetails.observe(this, Observer {
            handleResult(it)
        })
    }

    private fun handleResult(result: Result<PokemonDetails>) {
        when (result) {
            is Result.Success -> {
                setPokemonDetails(result.data)
            }
            is Result.Loading -> {
            }
            is Result.Error -> {
                Log.d("ERROR", result.cause.message ?: "")
            }
        }
    }

    private fun setPokemonDetails(details: PokemonDetails) {
        // iv_pokemon.setImageResource(details.images.frontDefault) //glide
        tv_pokemon_name.text = details.pokemonName
        tv_weight_value.text = details.weight
        tv_height_value.text = details.height
        tv_type_value.text = details.types[0].name
        tv_move_value.text = details.moves[0].name
        tv_ability_value.text = details.abilities[0].name

        pb_pokemon_details.gone()
        layout_pokemon_details.visible()
    }

    private fun closePokemonDetailsScreen() {
        finish()
    }
}