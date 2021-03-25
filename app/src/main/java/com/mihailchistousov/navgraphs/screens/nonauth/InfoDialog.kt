package com.mihailchistousov.navgraphs.screens.nonauth

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle(arguments?.getString("title"))
            .setMessage(
                arguments?.getString("message") ?: getString(R.string.default_error_message)
            )
            .setPositiveButton(
                arguments?.getString("positiveBtn") ?: getString(R.string.ok)
            ) { _, _ -> findNavController().popBackStack() }
            .setNegativeButton(arguments?.getString("negativeBtn")) { _, _ -> findNavController().popBackStack() }
            .create()
}