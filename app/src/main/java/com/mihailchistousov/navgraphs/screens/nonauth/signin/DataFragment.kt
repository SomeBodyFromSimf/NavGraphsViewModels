package com.mihailchistousov.navgraphs.screens.nonauth.signin

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

class DataFragment: Fragment(R.layout.data) {

    private val viewModel: SignInVM by navGraphViewModels(R.id.signIn)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "data sum is $s")
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(ReturnBackDialogDirections.toReturnDialog())
        }
        view.findViewById<Button>(R.id.go).setOnClickListener {
            viewModel.changeSum(999)
            findNavController().navigate(DataFragmentDirections.toMain())
        }
    }
}