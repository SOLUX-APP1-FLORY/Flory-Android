package com.solux.flory.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.usecase.PatchUserInfoUseCase
import com.solux.flory.domain.usecase.PostSignUpUseCase
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val postSignUpUseCase: PostSignUpUseCase,
    private val patchUserInfoUseCase: PatchUserInfoUseCase
) : ViewModel() {

    private val _postSignUpState = MutableStateFlow<UiState<Int?>>(UiState.Empty)
    val postSignUpState: StateFlow<UiState<Int?>> = _postSignUpState

    private val _patchUserInfoState = MutableStateFlow<UiState<Unit>>(UiState.Empty)
    val patchUserInfoState: StateFlow<UiState<Unit>> = _patchUserInfoState

    private var _gender = MutableLiveData("male")
    val gender: LiveData<String> get() = _gender

    fun postSignUp(uid: String, password: String, email: String) = viewModelScope.launch {
        _postSignUpState.emit(UiState.Loading)
        postSignUpUseCase(uid, password, email).fold(
            {
                if (it != null) _postSignUpState.emit(UiState.Success(it)) else _postSignUpState.emit(
                    UiState.Failure("400")
                )
            },
            { _postSignUpState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun patchUserInfo(id: Int, nickname: String, gender: String) = viewModelScope.launch {
        _patchUserInfoState.emit(UiState.Loading)
        patchUserInfoUseCase(id, nickname, gender).fold(
            {
                if (it != null) _patchUserInfoState.emit(UiState.Success(it)) else _patchUserInfoState.emit(
                    UiState.Failure("400")
                )
            },
            { _patchUserInfoState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun setGender(gender: String) {
        _gender.value = gender
    }
}