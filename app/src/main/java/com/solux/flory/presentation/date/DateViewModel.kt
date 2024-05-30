package com.solux.flory.presentation.date

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar

class DateViewModel : ViewModel() {
    private val calendar = Calendar.getInstance()
    private val monthNames = arrayOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )
    private val _year = MutableLiveData(calendar.get(Calendar.YEAR).toString())
    val year: LiveData<String> = _year

    private val _month = MutableLiveData(monthNames[calendar.get(Calendar.MONTH)])
    val month: LiveData<String> = _month

    private val _dateList = MutableLiveData<List<DateInfo>>()
    val dateList: LiveData<List<DateInfo>> = _dateList

    init {
        updateCalendar()
    }

    private fun updateCalendar() {
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        _year.value = calendar.get(Calendar.YEAR).toString()
        val currentMonth = calendar.get(Calendar.MONTH)
        _month.value = monthNames[currentMonth]

        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        val week = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = currentMonth + 1
        val list = MutableList(week, init = { DateInfo() })
        for (i in 1..maxDate) {
            list.add(DateInfo(month, i))
        }
        _dateList.value = list
    }

    fun moveToNextMonth() {
        calendar.add(Calendar.MONTH, 1)
        updateCalendar()
    }
}