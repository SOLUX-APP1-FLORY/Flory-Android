package com.solux.flory.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.usecase.PatchProfileUseCase
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileModifyViewModel @Inject constructor(
    private val patchProfileUseCase: PatchProfileUseCase,
) : ViewModel() {
    private val _patchProfileModifyState = MutableStateFlow<UiState<Unit>>(UiState.Empty)
    val patchProfileModifyState: StateFlow<UiState<Unit>> = _patchProfileModifyState

    fun patchProfileModify(nickname: String, gender: String, birthdate: String) =
        viewModelScope.launch {
            _patchProfileModifyState.emit(UiState.Loading)
            patchProfileUseCase(nickname, gender, birthdate).fold(
                {
                    _patchProfileModifyState.emit(UiState.Success(it))
                },
                { _patchProfileModifyState.emit(UiState.Failure(it.message.toString())) }
            )
        }
}