package pt.pprojects.pokelist.presentation.pokemondetails

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.pprojects.domain.Result
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.PokemonDetails
import pt.pprojects.pokelist.presentation.pokelist.PokeListActivity
import pt.pprojects.pokelist.presentation.gone
import pt.pprojects.pokelist.presentation.model.DetailItem
import pt.pprojects.pokelist.presentation.model.TypeItem
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

        setTypes(details.types)
        setMoves(details.moves)
        setAbilities(details.abilities)

        pb_pokemon_details.gone()
        layout_pokemon_details.visible()
    }

    private fun setTypes(types: List<TypeItem>) {
        when (types.size) {
            1 -> {
                tv_type1.text = types[0].name
                iv_type1.setImageResource(types[0].image)
            }
            2 -> {
                tv_type1.text = types[0].name
                iv_type1.setImageResource(types[0].image)

                tv_type2.text = types[1].name
                iv_type2.setImageResource(types[1].image)
                ll_type2.visible()
            }
            else -> {
                ll_type1.gone()
                ll_type_unknown.visible()
            }
        }
    }

    private fun setMoves(moves: List<DetailItem>) {
        val movesLayoutManager = LinearLayoutManager(this)
        val movesAdapter = DetailsAdapter()
        movesAdapter.addDetails(moves)

        rv_moves.layoutManager = movesLayoutManager
        rv_moves.adapter = movesAdapter
    }

    private fun setAbilities(abilities: List<DetailItem>) {
        val abilitiesLayoutManager = LinearLayoutManager(this)
        val abilitiesAdapter = DetailsAdapter()
        abilitiesAdapter.addDetails(abilities)

        rv_abilities.layoutManager = abilitiesLayoutManager
        rv_abilities.adapter = abilitiesAdapter
    }

    private fun closePokemonDetailsScreen() {
        finish()
    }
}