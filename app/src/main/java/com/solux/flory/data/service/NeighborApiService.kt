package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestNeighborFollowDto
import com.solux.flory.data.dto.request.RequestNeighborSearchDto
import com.solux.flory.data.dto.response.ResponseNeighborSearchDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.FOLLOW
import com.solux.flory.data.service.ApiKeyStorage.NEIGHBOR
import com.solux.flory.data.service.ApiKeyStorage.SEARCH
import com.solux.flory.data.service.ApiKeyStorage.UNFOLLOW
import com.solux.flory.data.service.ApiKeyStorage.USER
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface NeighborApiService {
    @GET("/$API/$V1/$NEIGHBOR")
    suspend fun getNeighborInfo(): BaseResponse<List<String>>

    @GET("/$API/$V1/$USER/$SEARCH")
    suspend fun getNeighborSearch(requestNeighborSearchDto: RequestNeighborSearchDto): BaseResponse<List<ResponseNeighborSearchDto>>

    @POST("/$API/$V1/$NEIGHBOR/$FOLLOW")
    suspend fun postNeighborFollow(requestNeighborFollowDto: RequestNeighborFollowDto): BaseResponse<String>

    @PATCH("/$API/$V1/$NEIGHBOR/$UNFOLLOW")
    suspend fun patchNeighborUnfollow(requestNeighborFollowDto: RequestNeighborFollowDto): BaseResponse<String>
}