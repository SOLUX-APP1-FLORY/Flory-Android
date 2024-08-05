package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.DiaryRepository
import javax.inject.Inject

class GetDiaryViewUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend operator fun invoke(year: Int, month: Int, day: Int) =
        diaryRepository.getDiaryView(year, month, day)
}