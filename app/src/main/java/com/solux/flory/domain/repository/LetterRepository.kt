package com.solux.flory.domain.repository

interface LetterRepository {
    suspend fun postLetter(
        flowerName: String,
        cardId: Int,
        receiver: String,
        content: String,
    ): Result<String?>
}