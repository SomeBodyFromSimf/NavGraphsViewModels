package com.mihailchistousov.navgraphs.screens.auth.main.main.localScreens.first

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.databinding.FirstLocalBinding
import com.mihailchistousov.navgraphs.screens.auth.main.main.MainVM
import com.mihailchistousov.navgraphs.utils.requireGrandParentFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFr : BaseFragment<MainVM>(R.layout.first_local) {
    override val viewModel: MainVM by viewModels({ requireGrandParentFragment() })

    private val binding by viewBinding(FirstLocalBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToSecond.setOnClickListener {
            findNavController().navigate(R.id.toSecond)
        }
        binding.logOut.setOnClickListener {
            requireGrandParentFragment().requireGrandParentFragment().findNavController()
                .navigate(R.id.logOut)
        }
    }
}