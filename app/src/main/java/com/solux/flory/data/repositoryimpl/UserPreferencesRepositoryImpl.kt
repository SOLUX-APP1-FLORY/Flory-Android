package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.UserPreferencesDataSource
import com.solux.flory.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserPreferencesRepositoryImpl @Inject constructor(
    private val dataSource: UserPreferencesDataSource
) : UserPreferencesRepository {

    override suspend fun saveUserAccessToken(accessToken: String) {
        dataSource.saveUserAccessToken(accessToken)
    }

    override fun getUserAccessToken(): Flow<String?> = dataSource.getUserAccessToken()

    override suspend fun saveCheckLogin(checkLogin: Boolean) {
        dataSource.saveCheckLogin(checkLogin)
    }

    override fun getCheckLogin(): Flow<Boolean> = dataSource.getCheckLogin()

    override suspend fun clear() = dataSource.clear()

}