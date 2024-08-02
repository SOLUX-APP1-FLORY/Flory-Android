package com.solux.flory.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.entity.ProfileUserEntity
import com.solux.flory.domain.repository.NeighborRepository
import com.solux.flory.domain.repository.ProfileRepository
import com.solux.flory.domain.repository.UserPreferencesRepository
import com.solux.flory.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val userPreferencesRepository: UserPreferencesRepository,
    private val neighborRepository: NeighborRepository
) : ViewModel() {
    private val _getProfileState = MutableStateFlow<UiState<ProfileUserEntity>>(UiState.Empty)
    val getProfileState: StateFlow<UiState<ProfileUserEntity>> = _getProfileState
    private val _getNeighborInfoState = MutableStateFlow<UiState<List<String>?>>(UiState.Empty)
    val getNeighborInfoState: StateFlow<UiState<List<String>?>> = _getNeighborInfoState

    init {
        getProfile()
        getNeighborInfo()
    }

    private fun getProfile() = viewModelScope.launch {
        _getProfileState.emit(UiState.Loading)
        profileRepository.getProfile().fold(
            {
                _getProfileState.emit(UiState.Success(it))
            },
            { _getProfileState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    fun getNeighborInfo() = viewModelScope.launch {
        _getNeighborInfoState.emit(UiState.Loading)
        neighborRepository.getNeighborInfo().fold(
            {
                _getNeighborInfoState.emit(UiState.Success(it))
            },
            { _getNeighborInfoState.emit(UiState.Failure(it.message.toString())) }
        )
    }

    val mockNeighbors = listOf(
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "가을"
        ),
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "고윤정"
        ),
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "철엘"
        ),
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "파타"
        ),
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "주빈"
        ),
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "강혜원"
        ),
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "선재"
        ),
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "필자"
        ),
        NeighborInfo(
            profileImage = "https://avatars.githubusercontent.com/u/91470334?v=4",
            profileName = "최상현상"
        ),
    )

    fun saveCheckLogin(checkLogin: Boolean) =
        viewModelScope.launch { userPreferencesRepository.saveCheckLogin(checkLogin) }
}