package ayoria.chagua.poketinderlab08.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import ayoria.chagua.poketinderlab08.databinding.ActivitySplashBinding
import ayoria.chagua.poketinderlab08.ui.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    
    private val splashViewModel: SplashViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        splashViewModel.getIsUnderMaintenance().observe(this){ isUnderMaintenance ->
            if(isUnderMaintenance){
                Toast.makeText(this, "Low maintenance", Toast.LENGTH_SHORT).show()
            }else{
                showAnimation()
            }
        }
    }

    private fun showAnimation(){
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // invoca el ciclo de vida
        }, 3000)
    }
}