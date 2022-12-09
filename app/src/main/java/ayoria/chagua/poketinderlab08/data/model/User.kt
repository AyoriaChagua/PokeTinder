package ayoria.chagua.poketinderlab08.data.model

import java.io.Serializable // es para que el objeto sea convertido en codigo binario... json a objeto y de objeto a json

data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String
) : Serializable {
    fun getImage() = "https://graph.facebook.com/$id/picture?type=large&width=720&height=720"
}
