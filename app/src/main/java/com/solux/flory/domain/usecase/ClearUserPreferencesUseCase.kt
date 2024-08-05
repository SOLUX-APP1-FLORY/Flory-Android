package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class ClearUserPreferencesUseCase @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke() = userPreferencesRepository.clear()
}