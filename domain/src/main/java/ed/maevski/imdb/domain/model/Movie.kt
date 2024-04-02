package ed.maevski.imdb.domain.model

data class Movie(
    val id: String,
    val title: String = "",
    val poster: String = "",
    val description: String = "",
    val rating: Float = 0.0f,
    val released: Int =0,
    var actors: List<Actor> = emptyList(),
    var trailerUrl: ArrayList<String> = arrayListOf(),
    var isInFavorites: Boolean = false
)
