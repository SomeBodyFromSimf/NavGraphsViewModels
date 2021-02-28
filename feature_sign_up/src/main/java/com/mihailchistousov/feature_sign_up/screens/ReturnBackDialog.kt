package com.mihailchistousov.feature_sign_up.screens

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.feature_sign_up.R
import com.mihailchistousov.navgraphs.R as ParentR

class ReturnBackDialog: DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage(getString(R.string.stop_sign_up))
            .setPositiveButton(getString(ParentR.string.yes_go)) { _,_ ->
                findNavController().popBackStack(ParentR.id.choiceFragment,false)
            }
            .setNegativeButton(getString(ParentR.string.no)) {_,_ ->
                findNavController().popBackStack()
            }
            .create()
}