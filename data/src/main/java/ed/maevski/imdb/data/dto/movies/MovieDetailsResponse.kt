package ed.maevski.imdb.data.dto.movies

data class MovieDetailsResponse (
    val genre: ArrayList<String>,
    val imageurl: ArrayList<String>,
    val imdbid: String,
    val imdbrating: Float,
    val language: ArrayList<String>,
    val released: Int,
    val runtime: String,
    val synopsis: String,
    val title: String,
    val type: String
)


