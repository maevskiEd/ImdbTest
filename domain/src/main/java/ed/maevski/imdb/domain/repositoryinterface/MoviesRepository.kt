package ed.maevski.imdb.domain.repositoryinterface

import ed.maevski.imdb.domain.model.Movie


interface MoviesRepository {

    suspend fun getAllMovies(): List<Movie>
    suspend fun getMovieDetailsById(imdbid: String): Movie
    suspend fun getMovieAdditionalDetailsById(movie: Movie): Movie


}