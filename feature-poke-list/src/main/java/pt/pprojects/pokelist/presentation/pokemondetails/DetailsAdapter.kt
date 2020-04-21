package pt.pprojects.pokelist.presentation.pokemondetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_detail.view.*
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.DetailItem

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {
    private var details: List<DetailItem> = listOf()

    fun addDetails(items: List<DetailItem>) {
        details = items
    }

    override fun getItemCount(): Int {
        return details.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = details[position]
        holder.bind(item.description)
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val detail: TextView = item.tv_detail

        fun bind(description: String) {
            detail.text = description
        }
    }
}
