package ed.maevski.imdb.domain.usecase

import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository

class GetMovieDetailsByIdUseCase(
    private val repository: MoviesRepository
) {
    suspend fun execute(imdbid: String): Movie = repository.getMovieDetailsById(imdbid)
}