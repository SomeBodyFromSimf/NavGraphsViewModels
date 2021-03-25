package com.mihailchistousov.navgraphs.screens.nonauth.splash

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mihailchistousov.navgraphs.base.BaseVM
import com.mihailchistousov.navgraphs.base.Event
import com.mihailchistousov.navgraphs.utils.after
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SplashVM @Inject constructor(
    @Named("APP_STR") private val appStr: String,
    @Named("VM_STR") private val vmStr: String,
    private val savedStateHandle: SavedStateHandle
) : BaseVM() {
    init {
        viewModelScope.after(1000) {
            tasksEventChannel.send(TimerEvent)
        }
    }
}

object TimerEvent : Event()