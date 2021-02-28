package com.mihailchistousov.navgraphs.screens.nonauth.choice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.fragment.findNavController
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.mihailchistousov.navgraphs.R

class ChoiceFragment: Fragment(R.layout.choice), Observer<SplitInstallSessionState> {

    private val viewModel: ChoiceVM by viewModels()

    private lateinit var installMonitor: DynamicInstallMonitor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val s = viewModel.getSum()
        Log.d("BaseVM", "choice sum is $s")
        view.findViewById<Button>(R.id.go_to_up).setOnClickListener {
            viewModel.changeSum(5)
            navigateToSignUp()
        }
        view.findViewById<Button>(R.id.go_to_in).setOnClickListener {
            findNavController().navigate(ChoiceFragmentDirections.toSignIn())
        }
    }

    private fun navigateToSignUp() {
        installMonitor = DynamicInstallMonitor()
        findNavController().navigate(ChoiceFragmentDirections.toSignUp(),DynamicExtras(installMonitor))
        if (installMonitor.isInstallRequired) {
            installMonitor.status.observe(viewLifecycleOwner, this)
        }
    }

    override fun onChanged(sessionState: SplitInstallSessionState) {
        when (sessionState.status()) {
            SplitInstallSessionStatus.INSTALLED -> {
                Toast.makeText(activity, "install", Toast.LENGTH_SHORT).show()
                findNavController().navigate(ChoiceFragmentDirections.toSignUp())
                // Call navigate again here or after user taps again in the UI:
                // navController.navigate(destinationId, destinationArgs, null, null)
            }
            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {

            }

            // Handle all remaining states:
            SplitInstallSessionStatus.FAILED -> {
                Toast.makeText(activity, "fail", Toast.LENGTH_SHORT).show()
            }
            SplitInstallSessionStatus.CANCELED -> {
                Toast.makeText(activity, "canceled", Toast.LENGTH_SHORT).show()
            }
            else -> Unit
        }

        if (sessionState.hasTerminalStatus()) {
            installMonitor.status.removeObserver(this)
        }
    }
}