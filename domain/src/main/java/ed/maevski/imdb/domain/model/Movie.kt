package ed.maevski.imdb.domain.model

data class Movie(
    val title: String,
    val poster: String,
    val description: String,
    var rating: Float,
    var isInFavorites: Boolean = false
)
