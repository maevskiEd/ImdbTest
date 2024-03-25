package ed.maevski.imdb.di

import ed.maevski.imdb.di.modules.AppModule
import ed.maevski.imdb.di.modules.DataModule
import ed.maevski.imdb.di.modules.DatabaseModule
import ed.maevski.imdb.di.modules.DomainModule
import ed.maevski.imdb.di.modules.RemoteModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        AppModule::class,
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class,
        DataModule::class
    ]
)
interface AppComponent {

}