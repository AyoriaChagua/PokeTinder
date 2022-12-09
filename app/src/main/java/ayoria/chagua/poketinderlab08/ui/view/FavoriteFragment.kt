package ayoria.chagua.poketinderlab08.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import ayoria.chagua.poketinderlab08.data.database.entities.MyPokemonEntity
import ayoria.chagua.poketinderlab08.databinding.FragmentFavoriteBinding
import ayoria.chagua.poketinderlab08.ui.adapter.MyPokemonAdapter
import ayoria.chagua.poketinderlab08.ui.viewmodel.FavoriteViewModel

class FavoriteFragment:
    BaseFragment<FragmentFavoriteBinding>
        (FragmentFavoriteBinding::inflate){

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private val listMyPokemon = mutableListOf<MyPokemonEntity>()

    private val adapter by lazy {MyPokemonAdapter(listMyPokemon)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteViewModel.getMyPokemons(requireContext())

        binding.rvPokemons.adapter = adapter

        favoriteViewModel.myPokemonList.observe(this){
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }
        binding.floatingActionDelete.setOnClickListener{
            favoriteViewModel.deleteAllPokemon(requireContext())
        }
    }
}