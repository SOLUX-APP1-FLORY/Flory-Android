package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.DiaryRepository
import javax.inject.Inject

class PatchDiaryUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend operator fun invoke(diaryId: Int, flower: String, title: String, content: String) =
        diaryRepository.patchDiary(diaryId, flower, title, content)
}