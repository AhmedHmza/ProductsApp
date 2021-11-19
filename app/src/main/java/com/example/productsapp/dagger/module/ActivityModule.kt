package com.example.productsapp.dagger.module

import android.app.Activity
import com.example.productsapp.ui.fragment.productlist.ProductListFragment
import com.example.productsapp.ui.main_activity.MainContract
import com.example.productsapp.ui.main_activity.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

    @Provides
    fun provideListFragment(): ProductListFragment {
        return ProductListFragment();
    }

}