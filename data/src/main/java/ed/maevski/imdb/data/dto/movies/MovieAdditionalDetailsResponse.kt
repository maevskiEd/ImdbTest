package ed.maevski.imdb.data.dto.movies

data class MovieAdditionalDetailsResponse(
    val imdbid: String,
    val numVotes: Int,
    val people: ArrayList<People>,
    val title: String,
    val trailerUrl: ArrayList<String>
)


