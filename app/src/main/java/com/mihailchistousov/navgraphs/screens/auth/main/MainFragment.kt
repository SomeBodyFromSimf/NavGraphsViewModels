package com.mihailchistousov.navgraphs.screens.auth.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mihailchistousov.navgraphs.MainDirections
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.setupWithNavController

class MainFragment: Fragment(R.layout.main) {

    private val viewModel: MainVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "main sum is $s")
        view.findViewById<Button>(R.id.go).setOnClickListener {
            viewModel.changeSum(3)
            findNavController().navigate(MainFragmentDirections.toMain2())
        }
        view.findViewById<Button>(R.id.logOut).setOnClickListener {
            findNavController().navigate(MainDirections.logOut())
        }
        if(savedInstanceState == null)
            view.findViewById<BottomNavigationView>(R.id.bNavView).init(childFragmentManager)

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        view?.findViewById<BottomNavigationView>(R.id.bNavView)?.init(childFragmentManager)

    }

    private fun BottomNavigationView?.init(fragmentManager: FragmentManager) {
        val navGraphIds = listOf(R.navigation.nav_local_calls, R.navigation.nav_local_end_calls, R.navigation.nav_local_info)
        this?.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = fragmentManager,
            containerId = R.id.local_nav_host_container,
        )
    }
}