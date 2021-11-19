package com.example.productsapp.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import com.example.productsapp.R
import com.example.productsapp.model.Product
import com.example.productsapp.ui.fragment.product_details.ProductDetailsFragment
import com.example.productsapp.util.Constants
import com.squareup.picasso.Picasso


class CartAdapter(val context: FragmentActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mProducts: MutableList<Product>

    fun addProducts(products: List<Product>?) {
        val lastPos = mProducts.size
        mProducts.addAll(products!!)
        notifyItemRangeInserted(lastPos, mProducts.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val row: View = inflater.inflate(R.layout.cart_item, parent, false)
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentProduct = mProducts[position]
        if (holder is ViewHolder) {
            val productHolder =
                holder as ViewHolder
            Picasso.get().load(currentProduct.image)
                .into(productHolder.imageViewProductThumb)
            productHolder.textViewProductName.setText(currentProduct.title)
            productHolder.textViewProductPrice.text = currentProduct.price.toString()
            productHolder.quantity.text = currentProduct.quantity.toString()
            productHolder.add.setOnClickListener {
                currentProduct.quantity++
                productHolder.quantity.text = currentProduct.quantity.toString()
            }
            productHolder.subtract.setOnClickListener {
                currentProduct.quantity--
                productHolder.quantity.text = currentProduct.quantity.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return mProducts.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageViewProductThumb: ImageView
        var textViewProductName: TextView
        var textViewProductPrice: TextView
        var quantity: TextView
        var add: TextView
        var subtract: TextView
        init {
            imageViewProductThumb = itemView.findViewById(R.id.cart_image)
            textViewProductName = itemView.findViewById(R.id.cart_item_name)
            textViewProductPrice = itemView.findViewById(R.id.cart_item_price)
            quantity = itemView.findViewById(R.id.quantity)
            add = itemView.findViewById(R.id.add)
            subtract = itemView.findViewById(R.id.subtract)
        }
    }

    init {
        mProducts = ArrayList()
    }
}