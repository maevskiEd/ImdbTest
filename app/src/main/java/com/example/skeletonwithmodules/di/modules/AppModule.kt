package com.example.skeletonwithmodules.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    //    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }
}
