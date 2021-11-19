package com.example.productsapp.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.productsapp.R
import com.example.productsapp.model.Product
import com.example.productsapp.ui.fragment.product_details.ProductDetailsFragment
import com.example.productsapp.ui.main_activity.MainActivity
import com.example.productsapp.util.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_details.*


class ProductsAdapter(val context: FragmentActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mProducts: MutableList<Product>

    //method to add products as soon as they fetched
    fun addProducts(products: List<Product>?) {
        val lastPos = mProducts.size
        mProducts.addAll(products!!)
        notifyItemRangeInserted(lastPos, mProducts.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val row: View = inflater.inflate(R.layout.product_list_item, parent, false)
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //get current product
        val currentProduct = mProducts[position]
        if (holder is ViewHolder) {
            val productHolder =
                holder as ViewHolder
            //bind products information with view
            productHolder.imageViewProductThumb.background = null
            productHolder.textViewProductPrice.background = null
            productHolder.textViewProductName.background = null
            productHolder.rating.background = null
            Picasso.get().load(currentProduct.image)
                .into(productHolder.imageViewProductThumb)
            productHolder.addToCart.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    if(currentProduct!=null){
                        (context as MainActivity).addProduct(currentProduct)
                    }
                }

            })
            productHolder.textViewProductName.setText(currentProduct.title)
            productHolder.rating.rating = currentProduct.rating.rate.toFloat()
            productHolder.ratingCount.text = "(" + currentProduct.rating.count.toString() + ")"
            productHolder.textViewProductPrice.text = currentProduct.price.toString()
            productHolder.itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                    val fragment = ProductDetailsFragment()
                    val bundle = Bundle()
                    bundle.putSerializable(Constants.PRODUCT, currentProduct)
                    fragment.arguments = bundle
                    (context).supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, fragment)
                        .addToBackStack(fragment.javaClass.name)
                        .commit()
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return mProducts.size
    }

    //Holds view of product with information
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageViewProductThumb: ImageView
        var textViewProductName: TextView
        var textViewProductPrice: TextView
        var ratingCount: TextView
        var rating: RatingBar
        var addToCart: Button

        init {
            imageViewProductThumb = itemView.findViewById(R.id.productImage)
            textViewProductName = itemView.findViewById(R.id.textViewProductName)
            textViewProductPrice = itemView.findViewById(R.id.textViewProductPrice)
            rating = itemView.findViewById(R.id.ratingBar)
            ratingCount = itemView.findViewById(R.id.ratingCount)
            addToCart = itemView.findViewById(R.id.addToCartButton)
        }
    }

    init {
        mProducts = ArrayList()
    }
}