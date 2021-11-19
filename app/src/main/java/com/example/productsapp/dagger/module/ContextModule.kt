package com.example.productsapp.dagger.module

import com.example.productsapp.application.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


@Module
class ContextModule @Inject constructor(val app:BaseApp){
    @Singleton
    @Provides
    public fun provideContext(): BaseApp {
        return app  ;
    }
}
