package ed.maevski.imdb.data.dto.movies

data class MovieData(
    val genre: ArrayList<String>,
    val imageurl: ArrayList<String>,
    val imdbid: String,
    val imdbrating: Float,
    val released: Int,
    val synopsis: String,
    val title: String,
    val type: String
)
