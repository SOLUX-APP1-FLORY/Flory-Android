package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.LetterRepository
import javax.inject.Inject

class PostLetterUseCase @Inject constructor(
    private val letterRepository: LetterRepository
) {
    suspend operator fun invoke(
        flowerName: String,
        receiverNickname: String,
        content: String,
    ) = letterRepository.postLetter(flowerName, receiverNickname, content)
}