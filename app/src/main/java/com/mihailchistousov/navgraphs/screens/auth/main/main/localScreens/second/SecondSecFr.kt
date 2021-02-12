package com.mihailchistousov.navgraphs.screens.auth.main.main.localScreens.second

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.requireGrandParentFragment
import com.mihailchistousov.navgraphs.screens.auth.main.main.MainVM

class SecondSecFr : Fragment(R.layout.second2_local){
    private val viewModel: MainVM by viewModels({requireGrandParentFragment()})


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "main local_22 sum is $s")
        viewModel.changeSum(22)
    }
}