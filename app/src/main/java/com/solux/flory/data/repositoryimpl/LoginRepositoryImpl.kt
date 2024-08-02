package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.LoginDataSource
import com.solux.flory.data.dto.request.RequestLoginDto
import com.solux.flory.domain.repository.LoginRepository
import timber.log.Timber
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource
): LoginRepository {
    override suspend fun postLogin(uid: String, password: String): Result<String?> {
        return runCatching {
            val data = loginDataSource.postLogin(RequestLoginDto(uid, password))
            data.result?.token
        }
    }
}