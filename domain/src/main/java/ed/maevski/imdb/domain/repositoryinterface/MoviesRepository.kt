package ed.maevski.imdb.domain.repositoryinterface

import ed.maevski.imdb.domain.model.Movie


interface MoviesRepository {

    fun getAllMovies(): List<Movie>

}