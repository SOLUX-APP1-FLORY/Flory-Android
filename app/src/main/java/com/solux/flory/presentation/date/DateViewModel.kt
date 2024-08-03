package com.solux.flory.presentation.date

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.entity.DiariesEntity
import com.solux.flory.domain.repository.DiaryRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class DateViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
) : ViewModel() {
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

    private val _getDiariesState = MutableStateFlow<UiState<DiariesEntity?>>(UiState.Empty)
    val getDiariesState: StateFlow<UiState<DiariesEntity?>> = _getDiariesState

    init {
        updateCalendar()
    }

    private suspend fun getImageUrlForDate(year: Int, month: Int, day: Int): String? {
        return withContext(Dispatchers.IO) {
            var imageUrl: String? = null
            diaryRepository.getDiaries(year, month, day).fold(
                {
                    imageUrl = it?.flowerUrl
                    _getDiariesState.emit(UiState.Success(it))
                },
                {
                    _getDiariesState.emit(UiState.Failure(it.message.toString()))
                }
            )
            imageUrl
        }
    }

    private fun updateCalendar() {
        viewModelScope.launch {
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