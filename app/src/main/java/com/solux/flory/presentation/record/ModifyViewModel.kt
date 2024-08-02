package com.solux.flory.presentation.record

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
class ModifyViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository
) : ViewModel() {
    private val _patchDiaryState = MutableStateFlow<UiState<Unit>>(UiState.Empty)
    val patchDiaryState: StateFlow<UiState<Unit>> = _patchDiaryState

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
}