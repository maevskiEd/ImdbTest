package ed.maevski.imdb.di.modules

import com.example.patients.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import ed.maevski.imdb.data.api.OttApi
import ed.maevski.imdb.data.mappers.IMoviesMapper
import ed.maevski.imdb.domain.repositoryinterface.MoviesRepository
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(
        ottApi: OttApi,
        mapper: IMoviesMapper
    ): MoviesRepository {
        return MovieRepositoryImpl(
            ottApi = ottApi,
            mapper = mapper
        )
    }
}