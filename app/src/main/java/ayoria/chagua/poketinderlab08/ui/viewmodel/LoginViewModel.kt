package ayoria.chagua.poketinderlab08.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ayoria.chagua.poketinderlab08.data.model.User
import ayoria.chagua.poketinderlab08.storage.SharedPreferenceUtil

class LoginViewModel(
    private val context: Context
):ViewModel() {//Automatizacion del ciclo de vida de la aplicacion
    private lateinit var sharedPreferencesUtil: SharedPreferenceUtil
    val emptyFieldError = MutableLiveData<Boolean>()
    val fieldsAuthenticationError = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    fun onCreate(){
        sharedPreferencesUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(
        email: String,
        password: String
    ){
        if(email.isEmpty() && password.isEmpty()) emptyFieldError.postValue(true)
        val user: User? = sharedPreferencesUtil.getUser()
        if(email == user?.email && password == user?.password) goSuccessActivity.postValue(true)
        else fieldsAuthenticationError.postValue(true)
    }
}