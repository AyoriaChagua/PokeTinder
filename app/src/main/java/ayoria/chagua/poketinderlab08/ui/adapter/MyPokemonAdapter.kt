package ayoria.chagua.poketinderlab08.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ayoria.chagua.poketinderlab08.R
import ayoria.chagua.poketinderlab08.data.database.entities.MyPokemonEntity
import ayoria.chagua.poketinderlab08.ui.holder.MyPokemonHolder

class MyPokemonAdapter(val list: List<MyPokemonEntity>):
    RecyclerView.Adapter<MyPokemonHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonHolder {
        val view = parent.inflate(R.layout.item_pokemon_save)
        return MyPokemonHolder(view)
    }


    override fun onBindViewHolder(holder: MyPokemonHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size
}