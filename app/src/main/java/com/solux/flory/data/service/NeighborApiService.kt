package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.NEIGHBOR
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.GET

interface NeighborApiService {
    @GET("/$API/$V1/$NEIGHBOR")
    suspend fun getNeighborInfo(): BaseResponse<List<String>>
}