package com.example.productsapp.ui.fragment.productlist

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productsapp.R
import com.example.productsapp.application.BaseApp
import com.example.productsapp.application.BaseFragment
import com.example.productsapp.dagger.component.DaggerProductListComponent
import com.example.productsapp.dagger.module.ProductListModule
import com.example.productsapp.model.Product
import com.example.productsapp.ui.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.fragment_product_list.*
import javax.inject.Inject


class ProductListFragment : BaseFragment(),
    ProductListContract.View {

    @Inject
    lateinit var presenter:ProductListContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shimmer_view_container.startShimmerAnimation()
        initDagger()
    }

    private fun initDagger() {
        val component = DaggerProductListComponent.builder().appComponent(BaseApp.appComponent).productListModule(
            ProductListModule(this)
        ).build()
        component.inject(this)
    }

    override fun onFetchFailed(message: String) {
        onFailed(message)
        shimmer_view_container.stopShimmerAnimation()
        shimmer_view_container.visibility = View.GONE
    }

    override fun onSuccess(action: List<Product>) {
        shimmer_view_container.stopShimmerAnimation()
        shimmer_view_container.visibility = View.GONE
        productLv.visibility = View.VISIBLE
        val adapter = activity?.let { ProductsAdapter(it) }
        adapter!!.addProducts(action)
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        productLv.adapter = adapter
        productLv.layoutManager = layoutManager
    }


}
