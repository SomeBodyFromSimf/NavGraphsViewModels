package com.mihailchistousov.navgraphs.screens.nonauth.signup

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.screens.nonauth.ReturnBackDialogDirections

class SignUpFragment: Fragment(R.layout.up) {

    private val viewModel: SignUpVM by navGraphViewModels(R.id.signUp)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "up sum is $s")
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(ReturnBackDialogDirections.toReturnDialog(false))
        }
        view.findViewById<Button>(R.id.go).setOnClickListener {
            viewModel.changeSum(1)
            findNavController().navigate(SignUpFragmentDirections.toSignUp2())
        }
    }
}