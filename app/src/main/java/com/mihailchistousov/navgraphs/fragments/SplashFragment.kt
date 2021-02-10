package com.mihailchistousov.navgraphs.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R

/**
 * Created by Mihail Chistousov on 10,Февраль,2021
 */
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