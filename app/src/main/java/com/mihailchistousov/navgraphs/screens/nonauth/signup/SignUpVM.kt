package com.mihailchistousov.navgraphs.screens.nonauth.signup

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mihailchistousov.navgraphs.base.*
import com.mihailchistousov.navgraphs.data.AuthRepo
import com.mihailchistousov.navgraphs.models.AdditionalInfo
import com.mihailchistousov.navgraphs.screens.nonauth.splash.TimerEvent
import com.mihailchistousov.navgraphs.utils.ResultState
import com.mihailchistousov.navgraphs.utils.after
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SignUpVM @Inject constructor(
    @Named("APP_STR") private val appStr: String,
    @Named("VM_STR") private val vmStr: String,
    private val authRepo: AuthRepo,
    private val savedStateHandle: SavedStateHandle
) : BaseVM() {

    init {
        Log.d("BaseVM(SignUp)", appStr)
        Log.d("BaseVM(SignUp)", vmStr)
    }

    fun signUp(login: String, pass: String, name: String, age: Int) = viewModelScope.launch {
        authRepo.signUp(login, pass, AdditionalInfo(login, pass, name, age)).onEach {
            when (it) {
                is ResultState.Loading -> tasksEventChannel.send(StartProgressEvent)
                is ResultState.Error -> {
                    tasksEventChannel.send(StopProgressEvent)
                    tasksEventChannel.send(
                        ShowInfoDialogEvent(
                            null,
                            it.exception.message ?: "Что-то пошло не так"
                        )
                    )
                }
                is ResultState.Success -> {
                    tasksEventChannel.send(StopProgressEvent)
                    tasksEventChannel.send(GoToSignUp2Event)
                }
            }
        }.collect()
    }

    fun goBack() = viewModelScope.after(2000) {
        tasksEventChannel.send(TimerEvent)
    }
}

object GoToSignUp2Event : Event()
