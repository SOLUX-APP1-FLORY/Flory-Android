package com.solux.flory.presentation.record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.entity.DiaryViewEntity
import com.solux.flory.domain.repository.DiaryRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModifyViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
) : ViewModel() {
    private val _patchDiaryState = MutableStateFlow<UiState<Unit>>(UiState.Empty)
    val patchDiaryState: StateFlow<UiState<Unit>> = _patchDiaryState

    private val _getDiaryViewState = MutableStateFlow<UiState<DiaryViewEntity>>(UiState.Empty)
    val getDiaryViewState: StateFlow<UiState<DiaryViewEntity>> = _getDiaryViewState

    fun patchDiary(diaryId: Int, flower: String, title: String, content: String) = viewModelScope.launch {
        _patchDiaryState.emit(UiState.Loading)
        diaryRepository.patchDiary(diaryId, flower, title, content).fold(
            {
                if (it != null) _patchDiaryState.emit(UiState.Success(it)) else _patchDiaryState.emit(
                    UiState.Failure("400")
                )
            },
            { _patchDiaryState.value = UiState.Failure(it.message.toString()) }
        )
    }

    fun getDiaryView(year: Int, month: Int, day: Int) = viewModelScope.launch {
        _getDiaryViewState.emit(UiState.Loading)
        diaryRepository.getDiaryView(year, month, day).fold(
            {
                if (it != null) _getDiaryViewState.emit(UiState.Success(it)) else _getDiaryViewState.emit(
                    UiState.Failure("400")
                )
            },
            { _getDiaryViewState.value = UiState.Failure(it.message.toString()) }
        )
    }
}