package com.mihailchistousov.navgraphs.screens.auth.main.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.mihailchistousov.navgraphs.R

class SettingFr: Fragment(R.layout.settings) {
    private val viewModel: SettingsVM by navGraphViewModels(R.id.settingFr)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
    }
}