package com.mihailchistousov.navgraphs.utils

import android.content.res.Resources
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun Fragment.requireGrandParentFragment() = this.requireParentFragment().requireParentFragment()

fun View.startAnim(animation: Animation, onEnd: () -> Unit) {
    animation.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) = Unit
        override fun onAnimationEnd(animation: Animation?) = onEnd()
        override fun onAnimationRepeat(animation: Animation?) = Unit
    })
    startAnimation(animation)
}

@Throws(Resources.NotFoundException::class)
fun Fragment.animation(@AnimRes id: Int): Animation = AnimationUtils.loadAnimation(context, id)

fun CoroutineScope.after(duration: Long, onEnd: suspend () -> Unit) = this.launch {
    delay(duration)
    onEnd()
}

fun Fragment.statusBarTextColor(isDark: Boolean) {
    val decorView = activity?.window?.decorView
    var flags = decorView?.systemUiVisibility
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
        flags =
            if (isDark) flags?.or(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) else flags?.xor(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        decorView?.systemUiVisibility = flags ?: View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R)
        activity?.window?.insetsController?.setSystemBarsAppearance(
            if (isDark) WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS else 0,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
}

