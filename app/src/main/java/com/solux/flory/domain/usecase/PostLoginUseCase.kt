package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.LoginRepository
import javax.inject.Inject

class PostLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(uid: String, password: String) = loginRepository.postLogin(uid, password)
}