package com.solux.flory.domain.usecase

import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.domain.repository.SignUpRepository
import javax.inject.Inject

class PostSignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository
) {
    suspend operator fun invoke(uid: String, password: String, email: String) =
        signUpRepository.postSignUp(uid, password, email)
}