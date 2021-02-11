package com.mihailchistousov.navgraphs.screens.nonauth.signin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.mihailchistousov.navgraphs.R

class SingIn2Fragment: Fragment(R.layout.in2) {

    private val viewModel: SignInVM by navGraphViewModels(R.id.signIn)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "in2 sum is $s")
        view.findViewById<Button>(R.id.go).setOnClickListener {
            viewModel.changeSum(99)
            findNavController().navigate(SingIn2FragmentDirections.toData())
        }
    }
}