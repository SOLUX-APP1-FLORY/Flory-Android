package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.LetterDataSource
import com.solux.flory.data.dto.request.RequestLetterDto
import com.solux.flory.domain.repository.LetterRepository
import javax.inject.Inject

class LetterRepositoryImpl @Inject constructor(
    private val letterDataSource: LetterDataSource
) : LetterRepository {
    override suspend fun postLetter(
        flowerName: String,
        cardId: Int,
        receiver: String,
        content: String
    ): Result<String?> {
        return runCatching {
            letterDataSource.postLetter(
                RequestLetterDto(
                    flowerName,
                    cardId,
                    receiver,
                    content
                )
            ).result?.message
        }
    }
}