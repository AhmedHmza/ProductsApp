package com.example.productsapp.dagger.module

import com.example.productsapp.api.ProductApiService
import com.example.productsapp.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    fun  provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.baseUrl)
            .build()

        return retrofit;
    }
}