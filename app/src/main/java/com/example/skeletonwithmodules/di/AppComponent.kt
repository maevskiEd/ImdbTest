package com.example.skeletonwithmodules.di

import com.example.skeletonwithmodules.di.modules.AppModule
import com.example.skeletonwithmodules.di.modules.DataModule
import com.example.skeletonwithmodules.di.modules.DatabaseModule
import com.example.skeletonwithmodules.di.modules.DomainModule
import com.example.skeletonwithmodules.di.modules.RemoteModule
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