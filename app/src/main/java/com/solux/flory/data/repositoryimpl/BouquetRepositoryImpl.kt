package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.BouquetDataSource
import com.solux.flory.data.mapper.toBouquetInfoEntity
import com.solux.flory.domain.entity.BouquetInfoEntity
import com.solux.flory.domain.repository.BouquetRepository
import com.solux.flory.presentation.gift.send.BouquetInfo
import javax.inject.Inject

class BouquetRepositoryImpl @Inject constructor(
    private val bouquetDataSource: BouquetDataSource
): BouquetRepository {
    override suspend fun getBouquetInfo(): Result<List<BouquetInfoEntity>?> {
        return runCatching {
            bouquetDataSource.getBouquetInfo().result?.map { it.toBouquetInfoEntity() }
        }
    }
}
