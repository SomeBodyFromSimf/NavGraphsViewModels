package com.mihailchistousov.navgraphs

import androidx.fragment.app.Fragment

fun Fragment.requireGrandParentFragment() = this.requireParentFragment().requireParentFragment()