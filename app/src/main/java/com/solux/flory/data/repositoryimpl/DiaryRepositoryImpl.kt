package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.DiaryDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryWriteDto
import com.solux.flory.domain.repository.DiaryRepository
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val diaryDataSource: DiaryDataSource
) : DiaryRepository {
    override suspend fun postDiary(flower: String, title: String, content: String): Result<String?> {
        return runCatching {
            diaryDataSource.postDiary(RequestDiaryWriteDto(flower, title, content)).result
        }
    }
}