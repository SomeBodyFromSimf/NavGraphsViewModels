package com.mihailchistousov.navgraphs.screens.nonauth.signin

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.databinding.DataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataFragment : BaseFragment<SignInVM>(R.layout.data) {

    override val viewModel: SignInVM by hiltNavGraphViewModels(R.id.signIn)

    private val binding by viewBinding(DataBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.toReturnDialog)
        }
        binding.go.setOnClickListener {
            findNavController().navigate(R.id.to_main)
        }
    }
}