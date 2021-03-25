package com.mihailchistousov.navgraphs.screens.auth.main.maps

import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.databinding.Maps2Binding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapsSecFr : BaseFragment<MapsVM>(R.layout.maps2) {
    override val viewModel: MapsVM by hiltNavGraphViewModels(R.id.maps)

    private val binding by viewBinding(Maps2Binding::bind)

}