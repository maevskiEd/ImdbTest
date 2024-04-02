package ed.maevski.imdb

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ed.maevski.imdb.di.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<App> =
        DaggerAppComponent.builder().withContext(applicationContext).build()
}