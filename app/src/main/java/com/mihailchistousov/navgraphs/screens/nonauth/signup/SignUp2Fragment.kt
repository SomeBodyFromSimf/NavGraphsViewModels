package com.mihailchistousov.navgraphs.screens.nonauth.signup

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.base.Event
import com.mihailchistousov.navgraphs.databinding.Up2Binding
import com.mihailchistousov.navgraphs.screens.nonauth.choice.ChoiceFragment
import com.mihailchistousov.navgraphs.screens.nonauth.splash.TimerEvent
import com.mihailchistousov.navgraphs.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUp2Fragment : BaseFragment<SignUpVM>(R.layout.up2) {

    override val viewModel: SignUpVM by hiltNavGraphViewModels(R.id.signUp)

    private val binding by viewBinding(Up2Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) { }
        viewModel.goBack()
    }

    override fun onEvent(event: Event) {
        super.onEvent(event)
        when (event) {
            is TimerEvent -> goBack()
        }
    }

    private fun goBack() {
        setFragmentResult(
            ChoiceFragment.REQUEST_KEY_CHOICE,
            bundleOf(Constants.IS_NEED_ANIM to false)
        )
        findNavController().popBackStack(R.id.choiceFragment, false)
    }
}