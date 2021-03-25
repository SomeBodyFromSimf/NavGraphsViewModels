package com.mihailchistousov.navgraphs.screens.auth.main.maps

import android.os.Bundle
import android.view.View
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.databinding.Maps1Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFr : BaseFragment<MapsVM>(R.layout.maps1) {

    override val viewModel: MapsVM by hiltNavGraphViewModels(R.id.maps)
    private val binding by viewBinding(Maps1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.go.setOnClickListener {
            findNavController().navigate(R.id.go_to_second)
        }
    }
}