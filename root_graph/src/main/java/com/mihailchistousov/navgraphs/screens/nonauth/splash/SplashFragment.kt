package com.mihailchistousov.navgraphs.screens.nonauth.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R

class SplashFragment: Fragment(R.layout.splash) {

    private val viewModel: SplashVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "splash sum is $s")
        view.findViewById<Button>(R.id.go).setOnClickListener {
            viewModel.changeSum(100)
            findNavController().navigate(SplashFragmentDirections.toChoice())
        }
    }
}