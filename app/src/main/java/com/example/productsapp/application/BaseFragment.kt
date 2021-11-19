package com.example.productsapp.application

import android.os.Bundle
import android.transition.TransitionInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.productsapp.R

open class BaseFragment : Fragment() {
    public fun onFailed(message:String){
        Toast.makeText(activity,message,Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
    }
}