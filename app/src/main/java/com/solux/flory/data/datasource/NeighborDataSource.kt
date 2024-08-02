package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse

interface NeighborDataSource {
    suspend fun getNeighborInfo(): BaseResponse<List<String>>
}