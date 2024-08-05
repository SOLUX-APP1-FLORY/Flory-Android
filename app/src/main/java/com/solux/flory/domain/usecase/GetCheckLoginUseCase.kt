package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class GetCheckLoginUseCase @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    operator fun invoke() = userPreferencesRepository.getCheckLogin()
}