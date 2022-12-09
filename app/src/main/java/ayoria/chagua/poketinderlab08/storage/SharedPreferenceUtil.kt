package ayoria.chagua.poketinderlab08.storage
import android.content.Context
import android.content.SharedPreferences
import ayoria.chagua.poketinderlab08.data.model.User
import com.google.gson.Gson

class SharedPreferenceUtil {
    companion object {
        //constantes inmutables que pueden ser usadas por cualquier funcion dentro de laclase
        private const val SHARED_PREFERENCE_KEY = "SHARED_PREFERENCE_KEY"
        private lateinit var sharedPreference: SharedPreferences
        private const val USER = "USER_KEY"
    }
    //instanciamos la libreria
    fun setSharedPreference(context: Context){
        sharedPreference = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)
    }

    fun saveUser(user: User){
        val gson = Gson()
        val jsonUser = gson.toJson(user) // convertimos los objetos a json para poder guardarlo
        sharedPreference
            .edit()// accedemos a la libreria
            .putString(USER, jsonUser) // guardamos la variable.. siempre se le debe pasar una llave
            .apply()
    }

    fun getUser(): User?{ // hacemos lo contrario de save user.. convertimos el json a objeto
        val gson = Gson()
        val user: User?
        val jsonUser = sharedPreference.getString(USER, "")
        user = gson.fromJson(jsonUser, User::class.java)
        return user
    }
}