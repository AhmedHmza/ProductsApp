package com.example.productsapp.dagger.component

import android.app.Activity
import com.example.productsapp.dagger.module.ActivityModule
import com.example.productsapp.dagger.module.PerApplication
import dagger.Component
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@PerView
@Component(modules = [ActivityModule::class], dependencies = [AppComponent::class])
public interface ProductActivityComponent {
    fun inject(activity : Activity)
}

