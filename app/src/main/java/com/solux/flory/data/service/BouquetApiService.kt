package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.response.ResponseBouquetDetailDto
import com.solux.flory.data.dto.response.ResponseBouquetInfoDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.BOUQUET
import com.solux.flory.data.service.ApiKeyStorage.GIFT
import com.solux.flory.data.service.ApiKeyStorage.GIFT_ID
import com.solux.flory.data.service.ApiKeyStorage.LETTER
import com.solux.flory.data.service.ApiKeyStorage.V1
import retrofit2.http.GET
import retrofit2.http.Path

interface BouquetApiService {
    @GET("/$API/$V1/$GIFT/$BOUQUET")
    suspend fun getBouquetInfo(): BaseResponse<List<ResponseBouquetInfoDto>>

    @GET("/$API/$V1/$GIFT/{$GIFT_ID}/$LETTER")
    suspend fun getBouquetDetail(
        @Path("giftId") giftId: Int,
    ): BaseResponse<ResponseBouquetDetailDto>
}