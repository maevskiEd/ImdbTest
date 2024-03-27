package ed.maevski.imdb.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.usecase.GetAllMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel() {

    private val _movieListFlow = MutableStateFlow<List<Movie>>(emptyList())
    val movieListFlow: StateFlow<List<Movie>> get() = _movieListFlow

    suspend fun getMovies() {
        println("ViewModel: getMovies")

        val movies: List<Movie> = getAllMoviesUseCase.execute()
        _movieListFlow.value = movies
    }

    class Factory(
        val getAllMoviesUseCase: GetAllMoviesUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(
                    getAllMoviesUseCase = getAllMoviesUseCase
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}