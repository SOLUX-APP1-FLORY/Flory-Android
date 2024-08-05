package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.DiaryRepository
import javax.inject.Inject

class GetDiaryCountUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {
    suspend operator fun invoke() = diaryRepository.getDiaryCount()
}