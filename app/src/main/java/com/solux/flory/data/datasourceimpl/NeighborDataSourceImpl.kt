package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.NeighborDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestNeighborFollowDto
import com.solux.flory.data.dto.request.RequestNeighborSearchDto
import com.solux.flory.data.dto.response.ResponseNeighborSearchDto
import com.solux.flory.data.service.NeighborApiService
import javax.inject.Inject

class NeighborDataSourceImpl @Inject constructor(
    private val neighborApiService: NeighborApiService
): NeighborDataSource{
    override suspend fun getNeighborInfo(): BaseResponse<List<String>> {
        return neighborApiService.getNeighborInfo()
    }

    override suspend fun getNeighborSearch(requestNeighborSearchDto: RequestNeighborSearchDto): BaseResponse<List<ResponseNeighborSearchDto>> {
        return neighborApiService.getNeighborSearch(requestNeighborSearchDto)
    }

    override suspend fun postNeighborFollow(requestNeighborFollowDto: RequestNeighborFollowDto): BaseResponse<String> {
        return neighborApiService.postNeighborFollow(requestNeighborFollowDto)
    }

    override suspend fun patchNeighborUnfollow(requestNeighborFollowDto: RequestNeighborFollowDto): BaseResponse<String> {
        return neighborApiService.patchNeighborUnfollow(requestNeighborFollowDto)
    }
}