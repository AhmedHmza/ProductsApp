package com.example.productsapp.repository

import com.example.productsapp.api.ProductApiService
import com.example.productsapp.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject
constructor(val api : ProductApiService) {

    fun fetchProducts(apiResponse: ApiResponse) {
        val call = api.getProductList()
        call.enqueue(object : Callback<List<Product>>{
            override fun onFailure(call: Call<List<Product>>?, t: Throwable?) {
                apiResponse.failed(t!!.message.toString())
            }

            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                response.body()?.let { apiResponse.success(it) }
            }

        })
    }
    public interface ApiResponse {
        fun failed(message:String)
        fun success(productsList:List<Product>)
    }
}