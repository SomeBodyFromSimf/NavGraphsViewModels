package com.mihailchistousov.navgraphs.screens.auth.main.main.localScreens.first

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.databinding.First2LocalBinding
import com.mihailchistousov.navgraphs.screens.auth.main.main.MainVM
import com.mihailchistousov.navgraphs.utils.requireGrandParentFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstSecFr : BaseFragment<MainVM>(R.layout.first2_local) {
    override val viewModel: MainVM by viewModels({ requireGrandParentFragment() })

    private val binding by viewBinding(First2LocalBinding::bind)
}