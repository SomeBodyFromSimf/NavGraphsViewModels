package com.mihailchistousov.navgraphs.screens.nonauth.signup

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.ProgressBar
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.base.Event
import com.mihailchistousov.navgraphs.databinding.UpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<SignUpVM>(R.layout.up) {

    override val viewModel: SignUpVM by hiltNavGraphViewModels(R.id.signUp)

    private val binding by viewBinding(UpBinding::bind)

    override val progress: ProgressBar? by lazy { binding.progress }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            val bundle = bundleOf("isSignIn" to false)
            findNavController().navigate(R.id.toReturnDialog, bundle)
        }
        binding.go.setOnClickListener { startSignUp() }
    }

    private fun startSignUp() = with(binding) {
        val login = etLogin.text.toString()
        val pass = etPass.text.toString()
        val name = etName.text.toString()
        val age = etAge.text.toString()


        //is login valid
        if (login.isBlank()) {
            etLogin.error = getString(R.string.empty_error);return@with
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(login).matches()) {
            etLogin.error = getString(R.string.not_correct_error);return@with
        }
        //is pass valid
        if (pass.isBlank()) {
            etPass.error = getString(R.string.empty_error);return@with
        }
        val pair = pass.filter { !it.isDigit() }.partition { it.isUpperCase() }
        if (pass.count() < 8 || pass.count { it.isDigit() } == 0 || pair.first.isEmpty() || pair.second.isEmpty()) {
            etPass.error = getString(R.string.pass_error);return@with
        }
        //is name valid
        if (name.isBlank()) {
            etName.error = getString(R.string.empty_error);return@with
        }
        // is age valid
        if (age.toIntOrNull() == null) {
            etAge.error = getString(R.string.not_correct_error);return@with
        }

        viewModel.signUp(login, pass, name, age.toIntOrNull() ?: 0)
    }

    override fun onEvent(event: Event) {
        super.onEvent(event)
        when (event) {
            is GoToSignUp2Event -> goToSignUp2()
        }
    }


    private fun goToSignUp2() {
        findNavController().navigate(R.id.to_sign_up_2)

    }
}