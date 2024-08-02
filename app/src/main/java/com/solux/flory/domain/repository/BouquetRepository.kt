package com.solux.flory.domain.repository

import com.solux.flory.domain.entity.BouquetInfoEntity

interface BouquetRepository {
    suspend fun getBouquetInfo(): Result<List<BouquetInfoEntity>?>
}