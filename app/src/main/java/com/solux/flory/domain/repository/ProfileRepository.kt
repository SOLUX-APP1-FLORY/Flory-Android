package com.solux.flory.domain.repository

import com.solux.flory.data.dto.response.ResponseProfileDto
import com.solux.flory.domain.entity.ProfileUserEntity

interface ProfileRepository {
    suspend fun getProfile(): Result<ProfileUserEntity>
    suspend fun patchProfile(nickname: String, gender: String, birthdate: String): Result<Unit>
}