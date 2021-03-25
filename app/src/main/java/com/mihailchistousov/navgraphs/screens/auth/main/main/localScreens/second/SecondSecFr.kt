package com.mihailchistousov.navgraphs.screens.auth.main.main.localScreens.second

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.databinding.Second2LocalBinding
import com.mihailchistousov.navgraphs.screens.auth.main.main.MainVM
import com.mihailchistousov.navgraphs.utils.requireGrandParentFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondSecFr : Fragment(R.layout.second2_local){
    private val viewModel: MainVM by viewModels({requireGrandParentFragment()})

    private val binding by viewBinding(Second2LocalBinding::bind)
}