package ed.maevski.imdb.data.mappers

import ed.maevski.imdb.data.dto.movies.MovieData
import ed.maevski.imdb.data.dto.movies.People
import ed.maevski.imdb.domain.model.Actor
import ed.maevski.imdb.domain.model.Movie

interface IMoviesMapper {
    fun toMovies(response: List<MovieData>): List<Movie>

    fun toActors(response: List<People>): List<Actor>
}