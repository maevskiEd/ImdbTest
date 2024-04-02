package ed.maevski.imdb.domain.usecase

import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository

class GetMovieAdditionalDetailsByIdUseCase(
    private val repository: MoviesRepository
) {
    suspend fun execute(movie: Movie): Movie = repository.getMovieAdditionalDetailsById(movie)
}