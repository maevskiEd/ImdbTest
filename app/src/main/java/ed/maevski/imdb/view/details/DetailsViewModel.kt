package ed.maevski.imdb.view.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ed.maevski.imdb.domain.model.Movie
import ed.maevski.imdb.domain.usecase.GetAllMoviesUseCase
import ed.maevski.imdb.domain.usecase.GetMovieAdditionalDetailsByIdUseCase
import ed.maevski.imdb.domain.usecase.GetMovieDetailsByIdUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getMovieDetailsByIdUseCase: GetMovieDetailsByIdUseCase,
    private val getMovieAdditionalDetailsByIdUseCase: GetMovieAdditionalDetailsByIdUseCase
) : ViewModel() {

    private var _selectedMovieFlow = MutableStateFlow<Movie?>(null)
    val selectedMovieFlow: StateFlow<Movie?> get() = _selectedMovieFlow
    suspend fun getMovieById(imdbid: String){
        viewModelScope.launch {
            val result1 = async { getMovieDetailsByIdUseCase.execute(imdbid) }

            // Ожидание завершения первой задачи
            var movie = result1.await()

//            getMovieDetailsByIdUseCase.execute(imdbid)
            delay(3000)

            movie = getMovieAdditionalDetailsByIdUseCase.execute(movie)

            println("DetailsViewModel: movie = $movie")

            _selectedMovieFlow.value = movie
        }
    }

    class Factory(
        val getMovieDetailsByIdUseCase: GetMovieDetailsByIdUseCase,
        val getMovieAdditionalDetailsByIdUseCase: GetMovieAdditionalDetailsByIdUseCase
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
                return DetailsViewModel(
                    getMovieDetailsByIdUseCase = getMovieDetailsByIdUseCase,
                    getMovieAdditionalDetailsByIdUseCase = getMovieAdditionalDetailsByIdUseCase
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}