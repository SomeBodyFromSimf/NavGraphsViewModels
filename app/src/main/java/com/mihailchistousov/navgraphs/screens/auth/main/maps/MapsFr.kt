package com.mihailchistousov.navgraphs.screens.auth.main.maps

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.mihailchistousov.navgraphs.R

class MapsFr: Fragment(R.layout.maps1) {

    private val viewModel: MapsVM by navGraphViewModels(R.id.maps)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        view.findViewById<Button>(R.id.go).setOnClickListener {
            viewModel.changeSum(444)
            findNavController().navigate(MapsFrDirections.goToSecond())
        }
    }
}