package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.ProfileRepository
import javax.inject.Inject

class PatchProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(nickname: String, gender: String, birthdate: String) =
        profileRepository.patchProfile(nickname, gender, birthdate)
}