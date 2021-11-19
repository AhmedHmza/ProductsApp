package com.example.productsapp.api

import android.provider.SyncStateContract
import com.example.productsapp.model.Product
import com.example.productsapp.util.Constants
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

abstract interface ProductApiService {

    @GET("products/")
    fun getProductList(): Call<List<Product>>

}