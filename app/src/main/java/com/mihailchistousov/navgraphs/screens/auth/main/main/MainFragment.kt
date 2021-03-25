package com.mihailchistousov.navgraphs.screens.auth.main.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.databinding.MainAuthBinding
import com.mihailchistousov.navgraphs.setupWithNavController
import com.mihailchistousov.navgraphs.utils.requireGrandParentFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainVM>(R.layout.main_auth) {

    override val viewModel: MainVM by viewModels()

    private val binding by viewBinding(MainAuthBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.go.setOnClickListener {
            requireGrandParentFragment().findNavController().navigate(R.id.to_main_2)
        }
        binding.logOut.setOnClickListener {
            requireGrandParentFragment().findNavController().navigate(R.id.logOut)
        }
        if (savedInstanceState == null)
            binding.bNavView.init(childFragmentManager)

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        binding.bNavView.init(childFragmentManager)

    }

    private fun BottomNavigationView?.init(fragmentManager: FragmentManager) {
        val navGraphIds = listOf(R.navigation.nav_local_calls, R.navigation.nav_local_end_calls, R.navigation.nav_local_info)
        this?.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = fragmentManager,
            containerId = R.id.local_nav_hosst_container,
        )
    }
}