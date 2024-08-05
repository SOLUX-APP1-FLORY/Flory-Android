package com.solux.flory.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.entity.ProfileUserEntity
import com.solux.flory.domain.usecase.GetDiaryCountUseCase
import com.solux.flory.domain.usecase.GetProfileUseCase
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDiaryCountUseCase: GetDiaryCountUseCase,
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {
    private val _rangeValue = MutableLiveData<Int>()
    private val _getDiaryCountState = MutableStateFlow<UiState<Int>>(UiState.Empty)
    val getDiaryCountState: StateFlow<UiState<Int>> = _getDiaryCountState

    private val _getProfileState = MutableStateFlow<UiState<ProfileUserEntity>>(UiState.Empty)
    val getProfileState: StateFlow<UiState<ProfileUserEntity>> = _getProfileState

    init {
        getDiaryCount()
        getProfile()
    }

    val rangeValue: LiveData<Int>
        get() = _rangeValue

    fun getDiaryCount() = viewModelScope.launch {
        _getDiaryCountState.emit(UiState.Loading)
        getDiaryCountUseCase().fold(
            {
                if (it != null) _getDiaryCountState.emit(UiState.Success(it)) else _getDiaryCountState.emit(
                    UiState.Failure("400")
                )
            },
            { _getDiaryCountState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun getProfile() = viewModelScope.launch {
        _getProfileState.emit(UiState.Loading)
        getProfileUseCase().fold(
            {
                _getProfileState.emit(UiState.Success(it))
            },
            { _getProfileState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun setRangeValue(value: Int) {
        _rangeValue.value = value
    }
}