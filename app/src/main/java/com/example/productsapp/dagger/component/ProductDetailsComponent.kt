package com.example.productsapp.dagger.component

import com.example.productsapp.dagger.module.ProductDetailsModule
import com.example.productsapp.dagger.module.ProductListModule
import com.example.productsapp.ui.fragment.product_details.ProductDetailsFragment
import com.example.productsapp.ui.fragment.productlist.ProductListFragment
import dagger.Component

@PerView
@Component(modules = [ProductDetailsModule::class],dependencies = [AppComponent::class])
abstract class ProductDetailsComponent {
    abstract fun inject(activity : ProductDetailsFragment)
}