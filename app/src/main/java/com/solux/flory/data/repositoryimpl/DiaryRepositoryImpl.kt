package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.DiaryDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestDiaryModifyDto
import com.solux.flory.data.dto.request.RequestDiaryWriteDto
import com.solux.flory.data.dto.response.ResponseDiariesDto
import com.solux.flory.data.dto.response.ResponseDiaryModifyDto
import com.solux.flory.data.mapper.toDiariesEntity
import com.solux.flory.domain.entity.DiariesEntity
import com.solux.flory.domain.repository.DiaryRepository
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val diaryDataSource: DiaryDataSource
) : DiaryRepository {
    override suspend fun postDiary(
        flower: String,
        title: String,
        content: String
    ): Result<String?> {
        return runCatching {
            diaryDataSource.postDiary(RequestDiaryWriteDto(flower, title, content)).result
        }
    }

    override suspend fun patchDiary(
        id: Int,
        title: String,
        content: String,
        flower: String
    ): Result<Unit> {
        return runCatching {
            diaryDataSource.patchDiary(RequestDiaryModifyDto(id, title, content, flower))
        }
    }

    override suspend fun getDiaries(year: Int, month: Int, day: Int): Result<DiariesEntity?> {
        return runCatching {
            diaryDataSource.getDiaries(year, month, day).result?.toDiariesEntity()
        }
    }
}