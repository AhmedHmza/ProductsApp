package com.example.productsapp.ui.fragment.productlist

import com.example.productsapp.model.Product
import com.example.productsapp.repository.ProductRepository
import com.example.productsapp.repository.ProductRepository.ApiResponse
import javax.inject.Inject

class ProductListPresenter :
    ProductListContract.Presenter
{

    private lateinit var repository: ProductRepository

    @Inject
    constructor(repository: ProductRepository,view: ProductListContract.View){
        this.repository = repository;
        repository.fetchProducts(object : ApiResponse {
            override fun failed(message:String){
                view.onFetchFailed(message)

            }

            override fun success(products:List<Product>){
                view.onSuccess(products)
            }
        })
    }
}