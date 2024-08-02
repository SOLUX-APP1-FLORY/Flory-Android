package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.response.ResponseBouquetInfoDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.BOUQUET
import com.solux.flory.data.service.ApiKeyStorage.GIFT
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.GET

interface BouquetApiService {
    @GET("/$API/$V1/$GIFT/$BOUQUET")
    suspend fun getBouquetInfo(): BaseResponse<List<ResponseBouquetInfoDto>>
}