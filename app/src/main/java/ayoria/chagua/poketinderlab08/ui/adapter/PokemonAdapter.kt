package ayoria.chagua.poketinderlab08.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ayoria.chagua.poketinderlab08.R
import ayoria.chagua.poketinderlab08.data.model.PokemonResponse
import ayoria.chagua.poketinderlab08.databinding.ItemPokemonBinding
import com.bumptech.glide.Glide


class PokemonAdapter(
    var list: List<PokemonResponse>,
    val callback: Callback
    ): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_pokemon)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPokemon = list[position]
        holder.bind(itemPokemon)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemPokemonBinding.bind(view)
        fun bind(pokemon: PokemonResponse) {
            with(binding) {//para evitar redundancia.. osea ya no llamamos varias veces
                root.setOnClickListener{
                    callback.onClickPokemonInformation(pokemon)
                }
                tvName.text = pokemon.name
                Glide
                    .with(itemView)
                    .load(pokemon.getPokemonImage())
                    .into(binding.ivPokemon)
            }
        }
    }

    interface Callback{
        fun onClickPokemonInformation(pokemon: PokemonResponse)
    }
}
fun ViewGroup.inflate(layoutRes: Int):
        View = LayoutInflater.from(context).inflate(layoutRes, this, false)