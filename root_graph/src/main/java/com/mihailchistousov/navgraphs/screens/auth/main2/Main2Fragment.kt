package com.mihailchistousov.navgraphs.screens.auth.main2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.MainDirections
import com.mihailchistousov.navgraphs.R

class Main2Fragment: Fragment(R.layout.main2) {
    private val viewModel: MainVM2 by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "main2 sum is $s")
        view.findViewById<Button>(R.id.logOut).setOnClickListener {
            findNavController().navigate(MainDirections.logOut())
        }
    }
}