package com.solux.flory.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.data.dto.request.RequestUserInfoDto
import com.solux.flory.domain.repository.NeighborRepository
import com.solux.flory.domain.repository.SignUpRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signUpRepository: SignUpRepository
) : ViewModel() {

    private val _postSignUpState = MutableStateFlow<UiState<Int?>>(UiState.Empty)
    val postSignUpState: StateFlow<UiState<Int?>> = _postSignUpState

    private val _patchUserInfoState = MutableStateFlow<UiState<String>>(UiState.Empty)
    val patchUserInfoState: StateFlow<UiState<String>> = _patchUserInfoState

    private var _gender = MutableLiveData("male")
    val gender: LiveData<String> get() = _gender

    fun postSignUp(id: String, password: String, email: String) = viewModelScope.launch {
        _postSignUpState.emit(UiState.Loading)
        signUpRepository.postSignUp(RequestSignUpDto(id, password, email)).fold(
            {
                if (it != null) _postSignUpState.emit(UiState.Success(it.result?.userId)) else _postSignUpState.emit(
                    UiState.Failure("400")
                )
            },
            { _postSignUpState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun patchUserInfo(id: Int, nickname: String, gender: String) = viewModelScope.launch {
        _patchUserInfoState.emit(UiState.Loading)
        signUpRepository.patchUserInfo(RequestUserInfoDto(id, nickname, gender)).fold(
            {
                if (it != null) _patchUserInfoState.emit(UiState.Success(it.result.toString())) else _patchUserInfoState.emit(
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