package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class SaveUserAccessTokenUseCase @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke(accessToken: String) =
        userPreferencesRepository.saveUserAccessToken(accessToken)
}