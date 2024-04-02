package ed.maevski.imdb.data.mappers

import ed.maevski.imdb.data.dto.movies.MovieAdditionalDetailsResponse
import ed.maevski.imdb.data.dto.movies.MovieData
import ed.maevski.imdb.data.dto.movies.MovieDetailsResponse
import ed.maevski.imdb.data.dto.movies.People
import ed.maevski.imdb.domain.model.Actor
import ed.maevski.imdb.domain.model.Movie
import javax.inject.Inject

class MoviesMapper @Inject constructor() : IMoviesMapper {
    override fun toMovies(response: List<MovieData>): List<Movie> {
        return response.map {

            println("MoviesMapper: MovieData: $it")

            it.toMovie()
        }
    }

    override fun toActors(response: List<People>): List<Actor> {
        return response.map {

            println("MoviesMapper: MovieData: $it")

            it.toActor()
        }
    }
}

fun MovieData.toMovie(): Movie =
    Movie(
        id = this.imdbid,
        title = this.title,
        poster = if (this.imageurl.isEmpty()) "" else this.imageurl[0],
        description = this.synopsis,
        rating = this.imdbrating,
        released = this.released,
        isInFavorites = false
    )

fun MovieDetailsResponse.toMovie(): Movie =
    Movie(
        id = this.imdbid,
        title = this.title,
        poster = if (this.imageurl.isEmpty()) "" else this.imageurl[0],
        description = this.synopsis,
        rating = this.imdbrating,
        released = this.released,
        isInFavorites = false
    )

fun People.toActor(): Actor =
    Actor(
        id = this.peopleid,
        name = "",
        image = "",
        characters = this.characters
    )
