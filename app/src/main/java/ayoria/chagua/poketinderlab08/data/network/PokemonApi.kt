package ayoria.chagua.poketinderlab08.data.network

import ayoria.chagua.poketinderlab08.data.model.PokemonListResponse
import ayoria.chagua.poketinderlab08.data.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {

    @GET("?limit=20")
    suspend fun getPokemon(): Response<PokemonListResponse>
}