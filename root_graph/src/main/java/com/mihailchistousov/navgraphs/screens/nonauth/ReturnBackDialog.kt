package com.mihailchistousov.navgraphs.screens.nonauth

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R

class ReturnBackDialog: DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.stop_sign_in))
            .setPositiveButton(getString(R.string.yes_go)) { _,_ ->
                findNavController().popBackStack(R.id.choiceFragment,false)
            }
            .setNegativeButton(getString(R.string.no)) {_,_ ->
                findNavController().popBackStack()
            }
            .create()
}