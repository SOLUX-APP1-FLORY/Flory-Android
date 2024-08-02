package com.solux.flory.domain.repository

interface LoginRepository {
    suspend fun postLogin(uid: String, password: String): Result<String?>
}