package ayoria.chagua.poketinderlab08.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import ayoria.chagua.poketinderlab08.databinding.FragmentInfoBinding
import ayoria.chagua.poketinderlab08.ui.viewmodel.InfoViewModel

class InfoFragment:BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate){

    private val viewModel: InfoViewModel by viewModels()

    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = binding.wvInfoFragment

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = PokemonWebClient()

        viewModel.getUrlPokemon().observe(viewLifecycleOwner){
            webView.loadUrl(it)
        }


    }

    inner class PokemonWebClient: WebViewClient(){
        override fun onPageFinished(view : WebView?, url : String? ){
            super.onPageFinished(view, url)
            webView.loadUrl("javascript:(function(){ " +
                "document.getElementByClassName('navbar top')[0].style.display='none;})()"
            )
        }
    }
}
