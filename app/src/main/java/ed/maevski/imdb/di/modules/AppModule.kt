package ed.maevski.imdb.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ed.maevski.imdb.domain.usecase.GetAllMoviesUseCase
import ed.maevski.imdb.domain.usecase.GetFavoritesMoviesUseCase
import ed.maevski.imdb.domain.usecase.GetMovieAdditionalDetailsByIdUseCase
import ed.maevski.imdb.domain.usecase.GetMovieDetailsByIdUseCase
import ed.maevski.imdb.view.details.DetailsViewModel
import ed.maevski.imdb.view.favorites.FavoritesViewModel
import ed.maevski.imdb.view.home.HomeViewModel

@Module
//class AppModule(val context: Context) {
class AppModule() {
//    @Provides
//    fun provideContext(): Context {
//        return context
//    }

    @Provides
    fun provideHomeViewModelFactory(
        getAllMoviesUseCase: GetAllMoviesUseCase
    ) = HomeViewModel.Factory(
        getAllMoviesUseCase = getAllMoviesUseCase
    )

    @Provides
    fun provideFavoritesViewModelFactory(
        getFavoritesMoviesUseCase: GetFavoritesMoviesUseCase
    ) = FavoritesViewModel.Factory(
        getFavoritesMoviesUseCase = getFavoritesMoviesUseCase
    )

    @Provides
    fun provideDetailsViewModelFactory(
        getMovieDetailsByIdUseCase: GetMovieDetailsByIdUseCase,
        getMovieAdditionalDetailsByIdUseCase: GetMovieAdditionalDetailsByIdUseCase
    ) = DetailsViewModel.Factory(
        getMovieDetailsByIdUseCase = getMovieDetailsByIdUseCase,
        getMovieAdditionalDetailsByIdUseCase = getMovieAdditionalDetailsByIdUseCase
    )
}
