package com.example.productsapp.application

import android.app.Application
import com.example.productsapp.dagger.component.AppComponent
import com.example.productsapp.dagger.component.DaggerAppComponent
import com.example.productsapp.dagger.module.ContextModule
import com.example.productsapp.dagger.module.RetrofitModule

class BaseApp : Application() {
    companion object{
        lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }

}
