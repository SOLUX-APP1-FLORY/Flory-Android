package com.solux.flory.domain.repository

interface LetterRepository {
    suspend fun postLetter(
        flowerName: String,
        receiverNickname: String,
        content: String,
    ): Result<String?>
}