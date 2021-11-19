package com.example.productsapp.ui.main_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import com.example.productsapp.R
import com.example.productsapp.application.BaseApp
import com.example.productsapp.dagger.component.DaggerProductActivityComponent
import com.example.productsapp.dagger.module.ActivityModule
import com.example.productsapp.model.Product
import com.example.productsapp.ui.CartActivity
import com.example.productsapp.ui.fragment.productlist.ProductListFragment
import com.example.productsapp.util.Constants
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var fragment: ProductListFragment
    val products:ArrayList<Product> = ArrayList<Product>()


    override fun onCreate(savedInstanceState: Bundle?)   {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDagger()
        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment,
                    ProductListFragment()
                )
                .commitAllowingStateLoss()
        }
        init()
    }

    private fun init() {

        topAppBar.setOnMenuItemClickListener(object: MenuItem.OnMenuItemClickListener,
            Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                   startCartActivity()
                    return true
            }

        })
    }

    private fun startCartActivity() {
        if(products!=null && products.size>0){
            val intent = Intent(this,CartActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(Constants.PRODUCT , products as Serializable)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Please Add products to Cart!!",Toast.LENGTH_LONG).show()
        }
    }

    private fun initDagger() {
        var component = DaggerProductActivityComponent.builder().appComponent(BaseApp.appComponent)
            .activityModule(ActivityModule(this)).build();
        component.inject(this)
    }

    fun addProduct(product: Product) {
        if(products.contains(product))
        products.forEach { item->
            if(product.id.equals(item.id)){
                products.remove(item)
                product.apply { quantity++  }
                products.add(product)
            }
        }
        else{
            product.quantity++
            products.add(product)
        }
    }
}
