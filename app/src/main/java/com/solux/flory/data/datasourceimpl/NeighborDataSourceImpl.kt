package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.NeighborDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.service.NeighborApiService
import javax.inject.Inject

class NeighborDataSourceImpl @Inject constructor(
    private val neighborApiService: NeighborApiService
): NeighborDataSource{
    override suspend fun getNeighborInfo(): BaseResponse<List<String>> {
        return neighborApiService.getNeighborInfo()
    }
}