package com.solux.flory.domain.usecase

import com.solux.flory.data.dto.request.RequestSignUpDto
import com.solux.flory.domain.repository.SignUpRepository
import javax.inject.Inject

class PostSignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository
) {
    suspend operator fun invoke(requestSignUpDto: RequestSignUpDto) =
        signUpRepository.postSignUp(requestSignUpDto)
}