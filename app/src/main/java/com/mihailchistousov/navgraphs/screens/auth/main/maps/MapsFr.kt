package com.mihailchistousov.navgraphs.screens.auth.main.maps

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R

class MapsFr: Fragment(R.layout.maps1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.go).setOnClickListener {
            findNavController().navigate(MapsFrDirections.goToSecond())
        }
    }
}