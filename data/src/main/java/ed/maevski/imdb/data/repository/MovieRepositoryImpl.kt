package com.example.patients.data.repository

import ed.maevski.imdb.data.api.OttApi
import ed.maevski.imdb.data.mappers.IMoviesMapper
import ed.maevski.imdb.data.mappers.toMovie
import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository

class MovieRepositoryImpl(
    private val ottApi: OttApi,
    private val mapper: IMoviesMapper,
) : MoviesRepository {
    override suspend fun getAllMovies(): List<Movie> {
        val moviesResponse = ottApi.getAllMovies(
            start_year = 1970,
            end_year = 2020,
            min_imdb = 6f,
            max_imdb = 7.8f,
            genre = "action",
            language = "english",
            type = "movie",
            sort = "latest",
            page = 1
        )

        println("moviesResponse: $moviesResponse")
        println("moviesResponse.results: ${moviesResponse.results}")

        val listMovie = mapper.toMovies(moviesResponse.results)

        println("listMovie: $listMovie")

        return listMovie
    }

    override suspend fun getMovieDetailsById(imdbid: String): Movie {
        val movieData = ottApi.getMovieDetailsById(imdbid)

        println("moviesResponse: $movieData")

        val movie = movieData.toMovie()

        return movie
    }

    override suspend fun getMovieAdditionalDetailsById(movie: Movie): Movie {
        val movieAdditionalDetailsResponse = ottApi.getMovieAdditionalDetailsById(movie.id)

        println("moviesResponse: $movieAdditionalDetailsResponse")

        val actors = mapper.toActors(movieAdditionalDetailsResponse.people)
        val trailerUrl = movieAdditionalDetailsResponse.trailerUrl
        movie.actors = actors
        movie.trailerUrl = trailerUrl
//        val listMovie = mapper.toMovies(moviesResponse.results)

        return movie
    }

}

