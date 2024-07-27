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
        val year = calendar.get(Calendar.YEAR)
        val week = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val month = currentMonth + 1
        val list = MutableList(week, init = { DateInfo() })
        for (i in 1..maxDate) {
            val imageUrl = getImageUrlForDate(year, month, i)
            list.add(DateInfo(year, month, i, imageUrl))
        }
        _dateList.value = list
    }

    private fun getImageUrlForDate(year: Int, month: Int, day: Int): String? {
        // 추후 꽃 정보 받아 오는 서버 통신 로직 구현하기
        if(year == 2024 && month == 7 && day == 24) return "https://github.com/SOLUX-APP1-FLORY/Flory-Frontend/assets/91470334/c30f7d95-8b84-4790-b1de-54cdfa7f7e70"
        else if(year == 2024 && month == 7 && day == 15) return "https://github.com/SOLUX-APP1-FLORY/Flory-Frontend/assets/91470334/ab9a2d92-c7e3-4f86-aae2-a23d9eb9ddfe"
        return null
    }

    fun moveToPreviousMonth() {
        calendar.add(Calendar.MONTH, -1)
        updateCalendar()
    }

    fun moveToNextMonth() {
        calendar.add(Calendar.MONTH, 1)
        updateCalendar()
    }
}