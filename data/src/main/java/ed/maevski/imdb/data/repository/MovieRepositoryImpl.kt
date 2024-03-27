package com.example.patients.data.repository

import ed.maevski.imdb.data.api.OttApi
import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository

class MovieRepositoryImpl(
    private val ottApi: OttApi
) : MoviesRepository {
    override fun getAllMovies(): List<Movie> {
        TODO("Not yet implemented")
    }

}

