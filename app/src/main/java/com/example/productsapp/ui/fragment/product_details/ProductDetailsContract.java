package com.example.productsapp.ui.fragment.product_details;

import android.os.Bundle;

import com.example.productsapp.model.Product;

import org.jetbrains.annotations.NotNull;

public interface ProductDetailsContract {
    interface View{

        void setProductDetails(@NotNull Product product);
    }

    interface Presenter{

        void checkBundle(@NotNull Bundle arguments);
    }
}
