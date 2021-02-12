package com.mihailchistousov.navgraphs.screens.auth.main.main.localScreens.third

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.requireGrandParentFragment
import com.mihailchistousov.navgraphs.screens.auth.main.main.MainVM

class ThirdFr : Fragment(R.layout.third_local){
    private val viewModel: MainVM by viewModels({requireGrandParentFragment()})


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "main local_31 sum is $s")
        view.findViewById<Button>(R.id.go_to_second).setOnClickListener {
            viewModel.changeSum(31)
            findNavController().navigate(ThirdFrDirections.toSecond())
        }
    }
}