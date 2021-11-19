package com.example.productsapp.dagger.module

import com.example.productsapp.api.ProductApiService
import com.example.productsapp.repository.ProductRepository
import com.example.productsapp.ui.fragment.productlist.ProductListContract
import com.example.productsapp.ui.fragment.productlist.ProductListFragment
import com.example.productsapp.ui.fragment.productlist.ProductListPresenter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ProductListModule constructor(val view: ProductListFragment) {

    @Provides
    fun provideProductRepository(retrofit:Retrofit): ProductRepository {
        return ProductRepository(retrofit.create(ProductApiService::class.java))
    }

    @Provides
    fun provideProductListPresenter(repository: ProductRepository): ProductListContract.Presenter {
        return ProductListPresenter(
            repository,
            view
        )
    }

}