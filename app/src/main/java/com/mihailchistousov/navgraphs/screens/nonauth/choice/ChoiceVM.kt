package com.mihailchistousov.navgraphs.screens.nonauth.choice

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mihailchistousov.navgraphs.base.BaseVM
import com.mihailchistousov.navgraphs.base.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ChoiceVM @Inject constructor(
    @Named("APP_STR") private val appStr: String,
    @Named("VM_STR") private val vmStr: String,
    private val savedStateHandle: SavedStateHandle
) : BaseVM() {

    fun showScreen(isAnim: Boolean) = viewModelScope.launch {
        tasksEventChannel.send(InitAndStartAnimEvent(isAnim))
    }
}

data class InitAndStartAnimEvent(val isAnim: Boolean) : Event()