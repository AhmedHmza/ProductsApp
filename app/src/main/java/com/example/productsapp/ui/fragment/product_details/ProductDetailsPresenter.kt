package com.example.productsapp.ui.fragment.product_details

import android.os.Bundle
import com.example.productsapp.model.Product
import com.example.productsapp.util.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_details.*
import kotlin.text.category

class ProductDetailsPresenter constructor(val view:ProductDetailsContract.View): ProductDetailsContract.Presenter {
    override fun checkBundle(arguments: Bundle) {
        val product = arguments!!.getSerializable(Constants.PRODUCT) as Product
        view.setProductDetails(product)
    }

}