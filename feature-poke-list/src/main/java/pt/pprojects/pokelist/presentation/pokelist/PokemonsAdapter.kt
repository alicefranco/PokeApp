package pt.pprojects.pokelist.presentation.pokelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_load_more.view.*
import kotlinx.android.synthetic.main.item_pokemon.view.*
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.ListItem
import pt.pprojects.pokelist.presentation.model.PokemonItem

class PokemonsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val LOADING_ITEM_VIEW = 1
    private val POKEMON_ITEM_VIEW = 2

    private var listItems: List<ListItem> = listOf()
    private val loadingItem = ListItem(ListItem.LOADING_ITEM)

    private var pokemonItemClick: (pokemonId: Int) -> Unit = {}
    private var loadMoreAction: () -> Unit = {}
    private var finished: Boolean = false

    fun addPokemons(pokemonItems: List<PokemonItem>, finished: Boolean) {
        val newItems: ArrayList<ListItem> = ArrayList(pokemonItems)

        when (listItems.isEmpty()) {
            true -> {
                newItems.add(loadingItem)
                listItems = newItems
            }
            false -> {
                val currentItems: ArrayList<ListItem> = ArrayList(listItems)
                currentItems.remove(currentItems.last())

                currentItems.addAll(newItems)
                if (!finished)
                    currentItems.add(loadingItem)

                listItems = currentItems
            }
        }
    }

    fun addPokemonItemClick(itemClickAction: (pokemonId: Int) -> Unit) {
        pokemonItemClick = itemClickAction
    }

    fun addLoadMoreAction(clickAction: () -> Unit) {
        loadMoreAction = clickAction
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun getItemViewType(position: Int): Int {
        var itemType = POKEMON_ITEM_VIEW
        when (listItems[position].itemType) {
            ListItem.LOADING_ITEM ->
                itemType = LOADING_ITEM_VIEW
            ListItem.LIST_ITEM ->
                itemType = POKEMON_ITEM_VIEW
        }
        return itemType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val loadingItemView = LayoutInflater.from(parent.context).inflate(R.layout.item_load_more, parent, false)
        val pokemonItemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)

        var viewHolder: RecyclerView.ViewHolder = ViewHolderPokemonItem(pokemonItemView)

        if (viewType == LOADING_ITEM_VIEW) {
            viewHolder = ViewHolderLoadMoreItem(loadingItemView)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType) {
            LOADING_ITEM_VIEW -> {
                (holder as ViewHolderLoadMoreItem).bind(loadMoreAction)
            }
            POKEMON_ITEM_VIEW -> {
                (holder as ViewHolderPokemonItem).bind(listItems[position] as PokemonItem, pokemonItemClick)
            }
        }
    }

    class ViewHolderPokemonItem(item: View) : RecyclerView.ViewHolder(item) {
        private val pokemonIdTextView: TextView = item.tv_pokemon_number
        private val pokemonNameTextView: TextView = item.tv_pokemon_name
        private val pokemonLayout: ConstraintLayout = item.layout_item_pokemon

        fun bind(pokemon: PokemonItem, itemClick: (pokemonId: Int) -> Unit) {
            pokemonIdTextView.text = pokemon.number
            pokemonNameTextView.text = pokemon.name
            pokemonLayout.setOnClickListener { itemClick(pokemon.number.toInt()) }
        }
    }

    class ViewHolderLoadMoreItem(item: View) : RecyclerView.ViewHolder(item) {
        private val loadingProgressBar: ProgressBar = item.pb_item_load_more

        fun bind(loadMoreAction: () -> Unit) {
            loadMoreAction()
        }
    }
}
