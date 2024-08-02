package com.solux.flory.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.repository.LoginRepository
import com.solux.flory.domain.repository.UserPreferencesRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    private val _postLoginState = MutableStateFlow<UiState<String>>(UiState.Empty)
    val postLoginState: StateFlow<UiState<String>> = _postLoginState

    fun postLogin(uid: String, password: String) = viewModelScope.launch {
        _postLoginState.emit(UiState.Loading)
        loginRepository.postLogin(uid, password).fold(
            {
                if (it != null) _postLoginState.emit(UiState.Success(it)) else _postLoginState.emit(
                    UiState.Failure("400")
                )
            },
            { _postLoginState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun getUserAccessToken() = userPreferencesRepository.getUserAccessToken()

    fun saveUserAccessToken(accessToken: String) {
        viewModelScope.launch {
            userPreferencesRepository.saveUserAccessToken(accessToken)
        }
    }

    fun getCheckLogin() = userPreferencesRepository.getCheckLogin()

    fun saveCheckLogin(checkLogin: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveCheckLogin(checkLogin)
        }
    }
}