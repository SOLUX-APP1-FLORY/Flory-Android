package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.SignUpDataSource
import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.data.dto.request.RequestUserInfoDto
import com.solux.flory.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val signUpDataSource: SignUpDataSource
) : SignUpRepository {
    override suspend fun postSignUp(
        uid: String, password: String, email: String
    ): Result<Int> {
        return runCatching {
            signUpDataSource.postSignUp(RequestSignUpDto(uid, password, email)).result?.userId ?: -1
        }
    }

    override suspend fun patchUserInfo(
        id: Int, nickname: String, gender: String
    ): Result<Unit> {
        return runCatching {
            signUpDataSource.patchUserInfo(RequestUserInfoDto(id, nickname, gender))
        }
    }

}