package com.solux.flory.data.repositoryimpl

import com.solux.flory.data.datasource.NeighborDataSource
import com.solux.flory.domain.repository.NeighborRepository
import javax.inject.Inject

class NeighborRepositoryImpl @Inject constructor(
    private val neighborDataSource: NeighborDataSource
) : NeighborRepository {
    override suspend fun getNeighborInfo(): Result<List<String>?> {
        return runCatching {
            neighborDataSource.getNeighborInfo().result
        }
    }
}
