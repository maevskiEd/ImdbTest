package ed.maevski.imdb

import android.app.Application
import ed.maevski.imdb.di.AppComponent
import ed.maevski.imdb.di.DaggerAppComponent
import ed.maevski.imdb.di.modules.AppModule
import ed.maevski.imdb.di.modules.DatabaseModule
import ed.maevski.imdb.di.modules.DomainModule
import ed.maevski.imdb.di.modules.RemoteModule


class App : Application() {
    lateinit var dagger: AppComponent
    override fun onCreate() {
        super.onCreate()

        instance = this
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule())
            .appModule(AppModule(context = this))
            .build()
    }

    companion object {
        //Здесь статически хранится ссылка на экземпляр App
        lateinit var instance: App
            //Приватный сеттер, чтобы нельзя было в эту переменную присвоить что-либо другое
            private set
    }
}