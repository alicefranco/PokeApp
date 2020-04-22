package pt.pprojects.pokelist.presentation.pokemondetails

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import kotlinx.android.synthetic.main.activity_pokemon_details.iv_pokemon
import kotlinx.android.synthetic.main.activity_pokemon_details.tv_pokemon_name
import org.koin.androidx.viewmodel.ext.android.viewModel
import pt.pprojects.domain.Result
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.PokemonDetails
import pt.pprojects.pokelist.presentation.pokelist.PokeListActivity
import pt.pprojects.pokelist.presentation.gone
import pt.pprojects.pokelist.presentation.model.DetailItem
import pt.pprojects.pokelist.presentation.model.TypeItem
import pt.pprojects.pokelist.presentation.showDialog
import pt.pprojects.pokelist.presentation.visible

class PokemonDetailsActivity : AppCompatActivity() {
    private val pokemonDetailsViewModel: PokemonDetailsViewModel by viewModel()
    private var pokemonId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        pokemonId = intent.getIntExtra(PokeListActivity.POKEMON_ID, 1)

        iv_close.setOnClickListener {
            closePokemonDetailsScreen()
        }

        pokemonId?.let { pokemonDetailsViewModel.getPokemonDetails(it) }

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
                pokemonId?.let { pokemonDetailsViewModel.getPokemonDetails(it) }
            },
            negativeAction = {
                finish()
            }
        )
    }

    private fun setPokemonDetails(details: PokemonDetails) {
        setImageWithGlide(iv_pokemon, details.images.frontDefault)

        setOptionalImage(iv_female, cl_female, details.images.frontFemale)
        setOptionalImage(iv_shiny, cl_male_shiny, details.images.frontShiny)
        setOptionalImage(iv_female_shiny, cl_female_shiny, details.images.frontFemaleShiny)

        tv_pokemon_number.text = details.pokemonNumber
        tv_pokemon_name.text = details.pokemonName
        tv_basexp_value.text = details.baseExperience
        tv_weight_value.text = details.weight
        tv_height_value.text = details.height

        setTypes(details.types)
        setMoves(details.moves)
        setAbilities(details.abilities)

        pb_pokemon_details.gone()
        layout_pokemon_details.visible()
    }

    fun setOptionalImage(
        imageView: ImageView,
        imageContainer: ConstraintLayout,
        resource: String?
    ) {
        resource?.let {
            if (resource.isNotEmpty()) {
                setImageWithGlide(imageView, it)
                cl_others.visible()
                imageContainer.visible()
            }
        }
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

    private fun setImageWithGlide(imageView: ImageView, resource: String) {
        Glide.with(this)
            .load(resource)
            .placeholder(R.drawable.ic_pokemon_placeholder)
            .into(imageView)
    }

    private fun closePokemonDetailsScreen() {
        finish()
    }
}