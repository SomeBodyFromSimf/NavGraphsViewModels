package com.mihailchistousov.navgraphs.screens.nonauth.choice

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailchistousov.navgraphs.R
import com.mihailchistousov.navgraphs.base.BaseFragment
import com.mihailchistousov.navgraphs.base.Event
import com.mihailchistousov.navgraphs.databinding.ChoiceBinding
import com.mihailchistousov.navgraphs.utils.Constants.IS_NEED_ANIM
import com.mihailchistousov.navgraphs.utils.statusBarTextColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChoiceFragment : BaseFragment<ChoiceVM>(R.layout.choice) {

    override val viewModel: ChoiceVM by viewModels()

    private val binding by viewBinding(ChoiceBinding::bind)

    private val isNeedAnim by lazy {
        arguments?.getBoolean("isNeedAnim", false) == true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showScreen(isNeedAnim)
        statusBarTextColor(true)
        setFragmentResultListener(REQUEST_KEY_CHOICE) { _, bundle ->
            init(bundle.getBoolean(IS_NEED_ANIM, false))
        }
    }

    override fun onEvent(event: Event) {
        super.onEvent(event)
        when (event) {
            is InitAndStartAnimEvent -> init(event.isAnim)
            else -> Unit
        }
    }

    private fun init(isAnimate: Boolean) {
        ObjectAnimator.ofFloat(if (isAnimate) 1f else 0.8f, 0.8f).apply {
            duration = if (isAnimate) 750 else 0
            interpolator = AccelerateDecelerateInterpolator()
            addUpdateListener { valueAnimator ->
                with(binding.guideline) {
                    val lp = layoutParams as ConstraintLayout.LayoutParams
                    lp.guidePercent = valueAnimator.animatedValue as Float
                    layoutParams = lp
                }
            }
            doOnEnd {
                if (isAnimate) ObjectAnimator.ofFloat(binding.title, "alpha", 1f).apply {
                    duration = 1000
                    start()
                }
                else binding.title.alpha = 1f
                initListeners()
            }
            start()
        }
    }

    private fun initListeners() {
        binding.btnSignUp.setOnClickListener { goToSignUp() }
        binding.btnSignIn.setOnClickListener { goToSignIn() }
    }

    private fun goToSignIn() {
        statusBarTextColor(false)
        findNavController().navigate(R.id.to_sign_in)
    }

    private fun goToSignUp() {
        statusBarTextColor(false)
        findNavController().navigate(R.id.to_sign_up)
    }

    companion object {
        const val REQUEST_KEY_CHOICE = "request_key_choice"
    }
}