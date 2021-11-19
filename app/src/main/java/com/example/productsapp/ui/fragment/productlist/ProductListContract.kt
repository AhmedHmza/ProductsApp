package com.example.productsapp.ui.fragment.productlist

import com.example.productsapp.model.Product

interface ProductListContract {
    interface Presenter

    interface View {
        fun onFetchFailed(message: String)
        fun onSuccess(action: List<Product>)
    }
}