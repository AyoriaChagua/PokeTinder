package ayoria.chagua.poketinderlab08.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import ayoria.chagua.poketinderlab08.data.database.PokemonDatabase
import ayoria.chagua.poketinderlab08.data.database.entities.MyPokemonEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel():ViewModel() {
    private val POKEMON_DATABSE_NAME = "pokemon_database"

    val myPokemonList = MutableLiveData<List<MyPokemonEntity>>()

    fun getMyPokemons(context: Context){
        CoroutineScope(Dispatchers.IO).launch{
            val myPokemons = getRoomDatabase(context).getPokemonDao().getAllPokemons()
            myPokemonList.postValue(myPokemons)
        }
    }

    fun deleteAllPokemon(context: Context){
        viewModelScope.launch {
            getRoomDatabase(context).getPokemonDao().deleteTable()
            myPokemonList.postValue(emptyList())
        }
    }

    private fun getRoomDatabase(context: Context):PokemonDatabase{
        return Room.databaseBuilder(
            context,
            PokemonDatabase::class.java,
            POKEMON_DATABSE_NAME
        ).build()
    }
}