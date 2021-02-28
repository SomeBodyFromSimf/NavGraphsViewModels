package com.mihailchistousov.navgraphs.base

import androidx.fragment.app.Fragment

fun Fragment.requireGrandParentFragment() = this.requireParentFragment().requireParentFragment()
