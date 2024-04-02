package ed.maevski.imdb.di

import android.content.Context
import dagger.BindsInstance
import ed.maevski.imdb.di.modules.AppModule
import ed.maevski.imdb.di.modules.DataModule
import ed.maevski.imdb.di.modules.DatabaseModule
import ed.maevski.imdb.di.modules.DomainModule
import ed.maevski.imdb.di.modules.RemoteModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ed.maevski.imdb.App
import ed.maevski.imdb.di.modules.MainModule
import ed.maevski.imdb.di.modules.MappersModule
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    modules = [
        AndroidInjectionModule::class,
        MainModule::class,
        AppModule::class,
        DatabaseModule::class,
        DataModule::class,
        DomainModule::class,
        MappersModule::class,
        RemoteModule::class,
    ]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withContext(context: Context): Builder
        fun build(): AppComponent
    }
}

