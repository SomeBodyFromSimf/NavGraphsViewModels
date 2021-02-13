package com.mihailchistousov.navgraphs.screens.nonauth

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mihailchistousov.navgraphs.R

class ReturnBackDialog: DialogFragment() {

    private val args: ReturnBackDialogArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(if(args.isSignIn) R.string.stop_sign_in else R.string.stop_sign_up))
            .setPositiveButton(getString(R.string.yes_go)) { _,_ ->
                findNavController().popBackStack(R.id.choiceFragment,false)
            }
            .setNegativeButton(getString(R.string.no)) {_,_ ->
                findNavController().popBackStack()
            }
            .create()
}