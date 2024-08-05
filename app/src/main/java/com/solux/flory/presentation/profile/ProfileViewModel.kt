package com.solux.flory.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.entity.ProfileUserEntity
import com.solux.flory.domain.repository.NeighborRepository
import com.solux.flory.domain.repository.ProfileRepository
import com.solux.flory.domain.repository.UserPreferencesRepository
import com.solux.flory.domain.usecase.GetNeighborInfoUseCase
import com.solux.flory.domain.usecase.GetProfileUseCase
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val userPreferencesRepository: UserPreferencesRepository,
    private val getNeighborInfoUseCase: GetNeighborInfoUseCase
) : ViewModel() {
    private val _getProfileState = MutableStateFlow<UiState<ProfileUserEntity>>(UiState.Empty)
    val getProfileState: StateFlow<UiState<ProfileUserEntity>> = _getProfileState

    private val _getNeighborInfoState = MutableStateFlow<UiState<List<String>>>(UiState.Empty)
    val getNeighborInfoState: StateFlow<UiState<List<String>>> = _getNeighborInfoState

    init {
        getProfile()
        getNeighborInfo()
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

    fun getNeighborInfo() = viewModelScope.launch {
        _getNeighborInfoState.emit(UiState.Loading)
        getNeighborInfoUseCase().fold(
            {
                _getNeighborInfoState.emit(UiState.Success(it))
            },
            { _getNeighborInfoState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun saveCheckLogin(checkLogin: Boolean) =
        viewModelScope.launch { userPreferencesRepository.saveCheckLogin(checkLogin) }
}