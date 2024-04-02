package ed.maevski.imdb.view.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.usecase.GetFavoritesMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(private val getFavoritesMoviesUseCase: GetFavoritesMoviesUseCase) : ViewModel() {

    init {
        viewModelScope.launch {
            getMovies()
        }
    }

    suspend fun getMovies() {
        println("ViewModel: getMovies")

//        val movies: List<Movie> = getAllMoviesUseCase.execute()

//        println("ViewModel: movies = $movies")

//        _movieListFlow.value = movies
    }

    class Factory(
        val getFavoritesMoviesUseCase: GetFavoritesMoviesUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
                return FavoritesViewModel(
                    getFavoritesMoviesUseCase = getFavoritesMoviesUseCase
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}