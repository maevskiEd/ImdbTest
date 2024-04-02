package ed.maevski.imdb.domain.usecase

import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository

class GetFavoritesMoviesUseCase(
    private val repository: MoviesRepository
) {
    suspend fun execute(): List<Movie> = repository.getAllMovies()
}