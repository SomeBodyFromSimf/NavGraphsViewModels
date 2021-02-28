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
import com.mihailchistousov.navgraphs.R  as ParentR

class SignUp2Fragment: Fragment(R.layout.up2) {

    private val viewModel: SignUpVM by navGraphViewModels(ParentR.id.feature_sign_up_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "up2 sum is $s")
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(SignUp2FragmentDirections.toReturnDialog())
        }
        view.findViewById<Button>(R.id.go).setOnClickListener {
            viewModel.changeSum(11)
            findNavController().popBackStack(ParentR.id.choiceFragment,false)
        }
    }
}