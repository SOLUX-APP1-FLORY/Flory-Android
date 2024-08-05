package com.solux.flory.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.usecase.GetNeighborInfoUseCase
import com.solux.flory.domain.usecase.PatchNeighborUnfollowUseCase
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NeighborsViewModel @Inject constructor(
    private val getNeighborInfoUseCase: GetNeighborInfoUseCase,
    private val patchNeighborUnfollowUseCase: PatchNeighborUnfollowUseCase
) : ViewModel() {
    private val _getNeighborInfoState = MutableStateFlow<UiState<List<String>>>(UiState.Empty)
    val getNeighborInfoState: StateFlow<UiState<List<String>>> = _getNeighborInfoState

    private val _patchNeighborUnfollowState = MutableStateFlow<UiState<String>>(UiState.Empty)
    val patchNeighborUnfollowState: StateFlow<UiState<String>> = _patchNeighborUnfollowState

    init {
        getNeighborInfo()
    }

    fun getNeighborInfo() = viewModelScope.launch {
        _getNeighborInfoState.emit(UiState.Loading)
        getNeighborInfoUseCase().fold(
            {
                _getNeighborInfoState.emit(UiState.Success(it))
            },
            { _getNeighborInfoState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun patchNeighborUnfollow(targetUserNickname: String) = viewModelScope.launch {
        _patchNeighborUnfollowState.emit(UiState.Loading)
        patchNeighborUnfollowUseCase(targetUserNickname).fold(
            {
                _patchNeighborUnfollowState.emit(UiState.Success(it))
            },
            { _patchNeighborUnfollowState.emit(UiState.Failure(it.message.toString())) }
        )
    }
}