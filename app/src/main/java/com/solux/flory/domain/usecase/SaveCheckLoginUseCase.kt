package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class SaveCheckLoginUseCase @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke(checkLogin: Boolean) =
        userPreferencesRepository.saveCheckLogin(checkLogin)
}