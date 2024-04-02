package ed.maevski.imdb.di.modules

import dagger.Module
import dagger.Provides
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository
import ed.maevski.imdb.domain.usecase.GetAllMoviesUseCase
import ed.maevski.imdb.domain.usecase.GetFavoritesMoviesUseCase
import ed.maevski.imdb.domain.usecase.GetMovieAdditionalDetailsByIdUseCase
import ed.maevski.imdb.domain.usecase.GetMovieDetailsByIdUseCase
import javax.inject.Singleton

@Module
class DomainModule() {
    @Singleton
    @Provides
    fun provideGetAllMoviesUseCase(repository: MoviesRepository): GetAllMoviesUseCase {
        return GetAllMoviesUseCase(repository = repository)
    }

    @Singleton
    @Provides
    fun provideGetFavoritesMoviesUseCase(repository: MoviesRepository): GetFavoritesMoviesUseCase {
        return GetFavoritesMoviesUseCase(repository = repository)
    }

    @Singleton
    @Provides
    fun provideGetMovieDetailsByIdUseCase(repository: MoviesRepository): GetMovieDetailsByIdUseCase {
        return GetMovieDetailsByIdUseCase(repository = repository)
    }

    @Singleton
    @Provides
    fun provideGetMovieAdditionalDetailsByIdUseCase(repository: MoviesRepository): GetMovieAdditionalDetailsByIdUseCase {
        return GetMovieAdditionalDetailsByIdUseCase(repository = repository)
    }
}