package com.mihailchistousov.navgraphs.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R

/**
 * Created by Mihail Chistousov on 10,Февраль,2021
 */
class ChoiceFragment: Fragment(R.layout.choice) {

    private val viewModel: ChoiceVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "choice sum is $s")
        view.findViewById<Button>(R.id.go_to_up).setOnClickListener {
            viewModel.changeSum(5)
            findNavController().navigate(ChoiceFragmentDirections.toSignUp())
        }
        view.findViewById<Button>(R.id.go_to_in).setOnClickListener {
            findNavController().navigate(ChoiceFragmentDirections.toSignIn())
        }
    }
}