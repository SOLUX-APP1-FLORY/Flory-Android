package com.solux.flory.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solux.flory.domain.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
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