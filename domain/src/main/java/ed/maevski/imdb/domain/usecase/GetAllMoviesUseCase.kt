package ed.maevski.imdb.domain.usecase

import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository

class GetAllMoviesUseCase(
    private val repository: MoviesRepository
) {
    fun execute(): List<Movie> = repository.getAllMovies()
}