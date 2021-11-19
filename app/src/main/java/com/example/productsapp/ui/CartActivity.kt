package com.example.productsapp.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productsapp.R
import com.example.productsapp.application.BaseActivity
import com.example.productsapp.model.Product
import com.example.productsapp.ui.adapter.CartAdapter
import com.example.productsapp.util.Constants
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        var products = intent.getSerializableExtra(Constants.PRODUCT) as List<Product>
        val adapter =CartAdapter(this,object : CartAdapter.QuantityUpdated{
            override fun setTotal(products: List<Product>) {
                setTotalBill(products)
            }
        })
        adapter!!.addProducts(products = products)
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cartLv.adapter = adapter
        cartLv.layoutManager = layoutManager
        setTotalBill(products)
    }

    fun setTotalBill(products: List<Product>) {
        var t = 0
        products.forEach {
            t+=(it.price.toInt()*it.quantity.toInt())
        }
        total.text = t.toString()
    }



}
