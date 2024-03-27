package ed.maevski.imdb.di.modules

import dagger.Module
import dagger.Provides
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository
import ed.maevski.imdb.domain.usecase.GetAllMoviesUseCase
import javax.inject.Singleton

@Module
class DomainModule() {
    @Singleton
    @Provides
    fun provideGetAllMoviesUseCase(repository: MoviesRepository): GetAllMoviesUseCase {
        return GetAllMoviesUseCase(repository = repository)
    }
}