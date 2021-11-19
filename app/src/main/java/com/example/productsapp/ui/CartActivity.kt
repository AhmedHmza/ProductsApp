package com.example.productsapp.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productsapp.R
import com.example.productsapp.application.BaseActivity
import com.example.productsapp.model.Product
import com.example.productsapp.ui.adapter.CartAdapter
import com.example.productsapp.ui.adapter.ProductsAdapter
import com.example.productsapp.util.Constants
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.fragment_product_list.*
import kotlinx.android.synthetic.main.fragment_product_list.productLv

class CartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val products = intent.getSerializableExtra(Constants.PRODUCT) as List<Product>
        val adapter =CartAdapter(this)
        adapter!!.addProducts(products = products)
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cartLv.adapter = adapter
        cartLv.layoutManager = layoutManager
        var t = {
            products.forEach { it->
                it.quantity++
            }
        }
        total.text = t.toString()
    }
}
