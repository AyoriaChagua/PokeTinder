package ayoria.chagua.poketinderlab08.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import ayoria.chagua.poketinderlab08.databinding.ActivityRegisterBinding
import ayoria.chagua.poketinderlab08.ui.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(
    ActivityRegisterBinding::inflate
) {
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewModel = RegisterViewModel(this)
        registerViewModel.onCreate()

        binding.btnRegister.setOnClickListener{
            startRegister()
            Toast.makeText(this,
                "Usuario reistrado satisfactoriamente", Toast.LENGTH_SHORT).show()
        }
        binding.btnGoLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        registerViewModel.emptyFieldError.observe(this){
            Toast.makeText(this,
                "Ingrese los datos del nuevo usuario", Toast.LENGTH_SHORT).show()
        }
        registerViewModel.goSuccessActivity.observe(this){
            startActivity(Intent(this, LoginActivity::class.java))
        }
        registerViewModel.errorComparePassword.observe(this){
            Toast.makeText(this,
                "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }
    }

    fun startRegister(){
        registerViewModel.validateInputs(
            binding.edtUserName.text.toString(),
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString(),
            binding.edtPassword2.text.toString()
        )
    }
}