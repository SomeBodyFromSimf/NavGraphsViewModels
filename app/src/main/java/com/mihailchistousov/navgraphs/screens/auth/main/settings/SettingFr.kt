package com.mihailchistousov.navgraphs.screens.auth.main.settings

import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.databinding.SettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFr : BaseFragment<SettingsVM>(R.layout.settings) {
    override val viewModel: SettingsVM by hiltNavGraphViewModels(R.id.settingFr)

    private val binding by viewBinding(SettingsBinding::bind)

}