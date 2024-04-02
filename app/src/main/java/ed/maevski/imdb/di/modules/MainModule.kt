package ed.maevski.imdb.di.modules


import dagger.Module
import dagger.android.ContributesAndroidInjector
import ed.maevski.imdb.view.MainActivity
import ed.maevski.imdb.view.details.DetailsFragment
import ed.maevski.imdb.view.favorites.FavoritesFragment
import ed.maevski.imdb.view.home.HomeFragment

@Module
interface MainModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    fun bindDetailsFragment(): DetailsFragment

    @ContributesAndroidInjector
    fun bindFavoritesFragment(): FavoritesFragment

}