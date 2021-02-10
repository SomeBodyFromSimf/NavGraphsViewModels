package com.mihailchistousov.navgraphs.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.mihailchistousov.navgraphs.R

/**
 * Created by Mihail Chistousov on 10,Февраль,2021
 */
class Main2Fragment: Fragment(R.layout.main2) {
    private val viewModel: MainVM by navGraphViewModels(R.id.main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "main2 sum is $s")
    }
}