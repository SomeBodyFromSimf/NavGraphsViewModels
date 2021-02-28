package com.mihailchistousov.feature_sign_up.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.mihailchistousov.feature_sign_up.SignUpVM
import com.mihailchistousov.feature_sign_up.R
import com.mihailchistousov.navgraphs.R as Parent

class SignUpFragment: Fragment(R.layout.up) {

    private val viewModel: SignUpVM by navGraphViewModels(Parent.id.feature_sign_up_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "up sum is $s")
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(SignUpFragmentDirections.toReturnDialog())
        }
        view.findViewById<Button>(R.id.go).setOnClickListener {
            viewModel.changeSum(1)
            findNavController().navigate(SignUpFragmentDirections.toSecond())
        }
    }
}