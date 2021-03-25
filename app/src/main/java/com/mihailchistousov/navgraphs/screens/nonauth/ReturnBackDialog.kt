package com.mihailchistousov.navgraphs.screens.nonauth

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.screens.nonauth.choice.ChoiceFragment.Companion.REQUEST_KEY_CHOICE
import com.mihailchistousov.navgraphs.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReturnBackDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(
                getString(
                    if (arguments?.getBoolean(
                            "isSignIn",
                            false
                        ) == true
                    ) R.string.stop_sign_in else R.string.stop_sign_up
                )
            )
            .setPositiveButton(getString(R.string.yes_go)) { _, _ ->
                setFragmentResult(REQUEST_KEY_CHOICE, bundleOf(Constants.IS_NEED_ANIM to false))
                findNavController().popBackStack(R.id.choiceFragment, false)
            }.setNegativeButton(getString(R.string.no)) { _, _ ->
                findNavController().popBackStack()
            }.create()
}