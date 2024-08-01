package com.solux.flory.domain.repository

interface DiaryRepository {
    suspend fun postDiary(flower: String, title: String, content: String): Result<String?>
}