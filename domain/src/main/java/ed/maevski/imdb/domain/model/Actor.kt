package ed.maevski.imdb.domain.model

data class Actor(
    val id: String,
    var name: String,
    var image: String,
    var characters: ArrayList<String>?
)
