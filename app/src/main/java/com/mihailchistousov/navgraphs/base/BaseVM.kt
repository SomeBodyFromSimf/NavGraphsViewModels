package com.mihailchistousov.navgraphs.base

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * Created by Mihail Chistousov on 10,Февраль,2021
 */
open class BaseVM : ViewModel() {

    private var summ = 0
    init {
        Log.d(TAG,"create ${javaClass.simpleName}")
    }

    fun changeSum(i: Int) {
        summ = i
    }

    fun getSum() = summ

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"clear ${javaClass.simpleName}")
    }

    companion object {
        const val TAG = "BaseVM"
    }
}