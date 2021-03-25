package com.mihailchistousov.navgraphs.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mihailchistousov.navgraphs.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

abstract class BaseFragment<VM : BaseVM>(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    protected abstract val viewModel: VM

    protected open val progress: ProgressBar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.tasksEvent.onEach {
                onEvent(
                    it
                )
            }.collect()
        }
    }

    protected open fun onEvent(event: Event) {
        when (event) {
            is StartProgressEvent -> progress?.isVisible = true
            is StopProgressEvent -> progress?.isVisible = false
            is ShowInfoDialogEvent -> showInfoDialog(
                event.title,
                event.message,
                event.positiveBtn,
                event.negativeBtn
            )
        }
    }

    protected fun showInfoDialog(
        title: String?,
        message: String,
        positiveBtnText: String? = null,
        negativeBtn: String? = null
    ) {
        val bundle = bundleOf(
            "title" to title,
            "message" to message,
            "positiveBtn" to positiveBtnText,
            "negativeBtn" to negativeBtn
        )
        findNavController().navigate(R.id.toInfoDialog, bundle)
    }
}