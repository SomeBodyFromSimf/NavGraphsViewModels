package com.mihailchistousov.navgraphs.screens.nonauth.splash

import android.view.animation.AccelerateInterpolator
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.base.Event
import com.mihailchistousov.navgraphs.databinding.SplashBinding
import com.mihailchistousov.navgraphs.utils.animation
import com.mihailchistousov.navgraphs.utils.startAnim
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashVM>(R.layout.splash) {

    override val viewModel: SplashVM by viewModels()

    private val binding by viewBinding(SplashBinding::bind)

    private val anim by lazy {
        animation(R.anim.splash_circle_anim).apply {
            duration = 700
            interpolator = AccelerateInterpolator()
        }
    }

    override fun onEvent(event: Event) {
        super.onEvent(event)
        when (event) {
            TimerEvent -> {
                binding.circle.isVisible = true
                binding.circle.startAnim(anim) { goToChoice() }
            }
            else -> Unit
        }
    }

    private fun goToChoice() {
        findNavController().navigate(R.id.to_choice)
    }
}