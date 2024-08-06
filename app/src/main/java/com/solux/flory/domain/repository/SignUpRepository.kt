package com.solux.flory.domain.repository

interface SignUpRepository {
    suspend fun postSignUp(
        uid: String, password: String, email: String
    ): Result<Int>

    suspend fun patchUserInfo(
        id: Int, nickname: String, gender: String
    ): Result<Unit>
}