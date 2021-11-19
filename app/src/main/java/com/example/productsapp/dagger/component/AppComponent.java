package com.example.productsapp.dagger.component;


import android.content.Context;

import com.example.productsapp.application.BaseApp;
import com.example.productsapp.dagger.module.ContextModule;
import com.example.productsapp.dagger.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {
        ContextModule.class,
        RetrofitModule.class
})
public interface AppComponent {

    Retrofit getRetrofitClient();

    BaseApp getApplicationContext();
}
