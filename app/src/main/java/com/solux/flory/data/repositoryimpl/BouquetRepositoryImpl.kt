package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.BouquetDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.mapper.toBouquetDetailEntity
import com.solux.flory.data.mapper.toBouquetInfoEntity
import com.solux.flory.domain.entity.BouquetDetailEntity
import com.solux.flory.domain.entity.BouquetInfoEntity
import com.solux.flory.domain.repository.BouquetRepository
import javax.inject.Inject

class BouquetRepositoryImpl @Inject constructor(
    private val bouquetDataSource: BouquetDataSource
): BouquetRepository {
    override suspend fun getBouquetInfo(): Result<List<BouquetInfoEntity>?> {
        return runCatching {
            bouquetDataSource.getBouquetInfo().result?.map { it.toBouquetInfoEntity() }
        }
    }

    override suspend fun getBouquetDetail(
        giftId: Int,
    ): Result<BouquetDetailEntity> {
        return runCatching {
            bouquetDataSource.getBouquetDetail(giftId).result?.toBouquetDetailEntity() ?: BouquetDetailEntity(
                "", "", "",""
            )
        }
    }
}
