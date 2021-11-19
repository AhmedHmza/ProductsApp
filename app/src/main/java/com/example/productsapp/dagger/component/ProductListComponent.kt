package com.example.productsapp.dagger.component

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.productsapp.dagger.module.ProductListModule
import com.example.productsapp.ui.fragment.productlist.ProductListFragment
import dagger.Component

@PerView
@Component(modules = [ProductListModule::class],dependencies = [AppComponent::class])
abstract class ProductListComponent {
    abstract fun inject(activity : ProductListFragment)
}