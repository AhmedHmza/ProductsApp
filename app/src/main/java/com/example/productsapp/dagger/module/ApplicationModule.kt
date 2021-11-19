package com.example.productsapp.dagger.module

import android.app.Application
import com.example.productsapp.application.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ApplicationModule @Inject constructor(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    public fun provideApplication(): Application {
        return baseApp
    }
}

annotation class PerApplication
