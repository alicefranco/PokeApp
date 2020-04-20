package pt.pprojects.pokelist.presentation.pokelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_pokemon.view.*
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.PokemonItem

class PokemonsAdapter() : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {
    private var pokemons: List<PokemonItem> = listOf()

    fun addPokemons(list: List<PokemonItem>) {
        pokemons = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val pokemonIdTextView: TextView = item.tv_pokemon_number
        private val pokemonNameTextView: TextView = item.tv_pokemon_name

        fun bind(pokemon: PokemonItem) {
            pokemonIdTextView.text = pokemon.number
            pokemonNameTextView.text = pokemon.name
        }
    }
}
