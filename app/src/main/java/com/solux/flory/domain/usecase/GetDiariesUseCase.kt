package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.DiaryRepository
import javax.inject.Inject

class GetDiariesUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend operator fun invoke(year: Int, month: Int, day: Int) =
        diaryRepository.getDiaries(year, month, day)
}