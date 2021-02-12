package com.mihailchistousov.navgraphs.screens.auth.main.maps

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.mihailchistousov.navgraphs.R


class MapsSecFr: Fragment(R.layout.maps2) {
    private val viewModel: MapsVM by navGraphViewModels(R.id.maps)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
    }
}