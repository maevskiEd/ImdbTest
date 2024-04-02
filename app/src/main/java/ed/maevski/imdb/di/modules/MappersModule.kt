package ed.maevski.imdb.di.modules

import dagger.Binds
import dagger.Module
import ed.maevski.imdb.data.mappers.IMoviesMapper
import ed.maevski.imdb.data.mappers.MoviesMapper
import javax.inject.Singleton

@Module
interface MappersModule {
    @Binds
    @Singleton
    fun bindNodesMapper(mapper: MoviesMapper): IMoviesMapper

}