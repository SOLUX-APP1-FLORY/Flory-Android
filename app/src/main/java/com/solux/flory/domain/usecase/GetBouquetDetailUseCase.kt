package com.solux.flory.domain.usecase

import com.solux.flory.domain.repository.BouquetRepository
import javax.inject.Inject

class GetBouquetDetailUseCase @Inject constructor(
    private val bouquetRepository: BouquetRepository
) {
    suspend operator fun invoke(giftId: Int) = bouquetRepository.getBouquetDetail(giftId)
}