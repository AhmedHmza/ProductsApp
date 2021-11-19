package com.example.productsapp.dagger.module

import android.app.Activity
import com.example.productsapp.ui.fragment.product_details.ProductDetailsContract
import com.example.productsapp.ui.fragment.product_details.ProductDetailsFragment
import com.example.productsapp.ui.fragment.product_details.ProductDetailsPresenter
import dagger.Module
import dagger.Provides

@Module
public class ProductDetailsModule constructor(val view: ProductDetailsFragment){
    @Provides
    fun providePresenter(): ProductDetailsContract.Presenter {
        return ProductDetailsPresenter(view)
    }
}
