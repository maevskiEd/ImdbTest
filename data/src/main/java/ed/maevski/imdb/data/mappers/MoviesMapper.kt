package ed.maevski.imdb.data.mappers

import ed.maevski.imdb.data.dto.movies.MovieData
import ed.maevski.imdb.domain.model.Movie

class MoviesMapper {
    fun toMovies(response: List<MovieData>): List<Movie>{
        return response.map {
            it.toMovie(it)
        }
    }

    fun MovieData.toMovie(movieData: MovieData): Movie = Movie(
        title = movieData.title,
        poster = movieData.imageurl[0],
        description = movieData.synopsis,
        rating = movieData.imdbrating,
        isInFavorites = false
    )
}