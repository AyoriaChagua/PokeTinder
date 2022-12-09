package ayoria.chagua.poketinderlab08.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ayoria.chagua.poketinderlab08.data.model.User
import ayoria.chagua.poketinderlab08.storage.SharedPreferenceUtil

class RegisterViewModel(
    private val context: Context
):ViewModel(){
    private lateinit var  sharedPreferencesUtil: SharedPreferenceUtil
    val emptyFieldError = MutableLiveData<Boolean>()
    val errorComparePassword = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    fun onCreate(){
        sharedPreferencesUtil = SharedPreferenceUtil().also{
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(
        username: String,
        email: String,
        password: String,
        passwordRepeat: String
    ){
        if(username.isEmpty() && email.isEmpty() && password.isEmpty() && passwordRepeat.isEmpty()){
            emptyFieldError.postValue(true)
        }else{
            if(password == passwordRepeat){
                val userId = "1"
                val user = User (userId, username, email, password)
                sharedPreferencesUtil.saveUser(user)
                goSuccessActivity.postValue(true)
            }else errorComparePassword.postValue(true)
        }
    }
}