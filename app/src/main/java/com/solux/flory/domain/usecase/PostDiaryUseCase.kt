package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.DiaryRepository
import javax.inject.Inject

class PostDiaryUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend operator fun invoke(flower: String, title: String, content: String) =
        diaryRepository.postDiary(flower, title, content)
}