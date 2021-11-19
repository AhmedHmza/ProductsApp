package com.example.productsapp.ui.fragment.product_details

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.productsapp.R
import com.example.productsapp.application.BaseApp
import com.example.productsapp.application.BaseFragment
import com.example.productsapp.dagger.component.DaggerProductDetailsComponent
import com.example.productsapp.dagger.component.DaggerProductListComponent
import com.example.productsapp.dagger.module.ProductDetailsModule
import com.example.productsapp.dagger.module.ProductListModule
import com.example.productsapp.model.Product
import com.example.productsapp.ui.main_activity.MainActivity
import com.example.productsapp.util.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_details.*
import kotlinx.android.synthetic.main.fragment_product_list.*
import javax.inject.Inject

class ProductDetailsFragment : BaseFragment(),ProductDetailsContract.View {

    private lateinit var product: Product
    @Inject lateinit var presenter:ProductDetailsContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDagger()
        if(arguments!=null){
            presenter.checkBundle(arguments!!)
        }
        addToCartButton.setOnClickListener(object : OnClickListener{
            override fun onClick(v: View?) {
                if(product!=null){
                    (activity as MainActivity).addProduct(product)
                }
            }

        })
    }

    private fun initDagger() {
        val component = DaggerProductDetailsComponent.builder().appComponent(BaseApp.appComponent).productDetailsModule(
            ProductDetailsModule(this)
        ).build()
        component.inject(this)
    }

    override fun setProductDetails(product: Product) {
        this.product = product
        Picasso.get().load(product.image)
            .into(photo)
        product_name.text = product.title
        description.text = product.description
        thePriceOfProduct.text = product.price.toString() + "$"
        ratingCount.text ="("+ product.rating.count +")"
        ratingBar.rating = product.rating.rate.toFloat()
        category.text = product.category
    }
}
