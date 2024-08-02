package com.solux.flory.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.repository.DiaryRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
): ViewModel(){
    private val _rangeValue = MutableLiveData<Int>()
    private val _getDiaryCountState = MutableStateFlow<UiState<Int>>(UiState.Empty)
    val getDiaryCountState: StateFlow<UiState<Int>> = _getDiaryCountState

    init {
        getDiaryCount()
    }

    fun getDiaryCount() = viewModelScope.launch {
        _getDiaryCountState.emit(UiState.Loading)
        diaryRepository.getDiaryCount().fold(
            {
                if (it != null) _getDiaryCountState.emit(UiState.Success(it)) else _getDiaryCountState.emit(
                    UiState.Failure("400")
                )
            },
            { _getDiaryCountState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    val rangeValue: LiveData<Int>
        get() = _rangeValue

    init {
        _rangeValue.value = 23
    }

    fun setRangeValue(value: Int) {
        _rangeValue.value = value
    }
}