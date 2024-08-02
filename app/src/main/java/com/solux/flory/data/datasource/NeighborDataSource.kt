package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestNeighborFollowDto
import com.solux.flory.data.dto.request.RequestNeighborSearchDto
import com.solux.flory.data.dto.response.ResponseNeighborSearchDto

interface NeighborDataSource {
    suspend fun getNeighborInfo(): BaseResponse<List<String>>
    suspend fun getNeighborSearch(requestNeighborSearchDto: RequestNeighborSearchDto): BaseResponse<List<ResponseNeighborSearchDto>>
    suspend fun postNeighborFollow(requestNeighborFollowDto: RequestNeighborFollowDto): BaseResponse<String>
    suspend fun patchNeighborUnfollow(requestNeighborFollowDto: RequestNeighborFollowDto): BaseResponse<String>
}