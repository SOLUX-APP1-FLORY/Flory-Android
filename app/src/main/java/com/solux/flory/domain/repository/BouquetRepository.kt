package com.solux.flory.domain.repository

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.domain.entity.BouquetDetailEntity
import com.solux.flory.domain.entity.BouquetInfoEntity

interface BouquetRepository {
    suspend fun getBouquetInfo(): Result<List<BouquetInfoEntity>?>
    suspend fun getBouquetDetail(giftId: Int): Result<BouquetDetailEntity>
}