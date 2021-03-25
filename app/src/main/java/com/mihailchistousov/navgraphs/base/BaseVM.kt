package com.mihailchistousov.navgraphs.base

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

open class BaseVM : ViewModel() {

    protected val tasksEventChannel = Channel<Event>()
    val tasksEvent =
        tasksEventChannel.receiveAsFlow().shareIn(viewModelScope, SharingStarted.Lazily, 0)

    @Inject
    lateinit var resources: Resources

}

open class Event

object LogOffEvent : Event()
object StartProgressEvent : Event()
object StopProgressEvent : Event()
data class ShowInfoDialogEvent(
    val title: String?,
    val message: String,
    val positiveBtn: String? = null,
    val negativeBtn: String? = null
) : Event()
