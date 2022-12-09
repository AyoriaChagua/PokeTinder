package ayoria.chagua.poketinderlab08.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

//Aplicamos la herencia para usar funciones y eso
//B se puede interpretar como un binding

//hacemos la clase bse para que sea heredada en todos los activities
abstract class BaseActivity<B: ViewBinding>(val bindingFactory: (LayoutInflater) ->B):AppCompatActivity() {
    lateinit var binding: B
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }


}




































