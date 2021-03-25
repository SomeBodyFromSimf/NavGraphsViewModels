package com.mihailchistousov.navgraphs.screens.nonauth.signin

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.mihailchistousov.navgraphs.base.BaseVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SignInVM @Inject constructor(
    @Named("APP_STR") private val appStr: String,
    @Named("VM_STR") private val vmStr: String,
    private val savedStateHandle: SavedStateHandle
) : BaseVM() {
    init {
        Log.d("BaseVM(SignInVM)", appStr)
        Log.d("BaseVM(SignInVM)", vmStr)
    }
}