package ed.maevski.imdb.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ed.maevski.imdb.domain.usecase.GetAllMoviesUseCase
import ed.maevski.imdb.view.home.HomeViewModel

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideHomeViewModelFactory(
        getAllMoviesUseCase: GetAllMoviesUseCase
    ) = HomeViewModel.Factory(
        getAllMoviesUseCase = getAllMoviesUseCase
    )
}
