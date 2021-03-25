package com.mihailchistousov.navgraphs.screens.auth.main2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.databinding.Main2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Main2Fragment : BaseFragment<MainVM2>(R.layout.main2) {
    override val viewModel: MainVM2 by viewModels()

    private val binding by viewBinding(Main2Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.logOut.setOnClickListener {
            findNavController().navigate(R.id.logOut)
        }
    }
}