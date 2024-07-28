package com.solux.flory.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(){
    private val _rangeValue = MutableLiveData<Int>()
    val rangeValue: LiveData<Int>
        get() = _rangeValue

    init {
        _rangeValue.value = 23
    }

    fun setRangeValue(value: Int) {
        _rangeValue.value = value
    }
}