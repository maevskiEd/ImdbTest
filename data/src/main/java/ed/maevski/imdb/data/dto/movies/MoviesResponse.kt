package ed.maevski.imdb.data.dto.movies

data class MoviesResponse (
    val page: Int,
    val results: ArrayList<MovieData>,
)
