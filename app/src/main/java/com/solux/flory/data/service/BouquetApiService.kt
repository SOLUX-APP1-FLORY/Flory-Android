package com.solux.flory.data.service

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestBouquetDetailDto
import com.solux.flory.data.dto.response.ResponseBouquetDetailDto
import com.solux.flory.data.dto.response.ResponseBouquetInfoDto
import com.solux.flory.data.service.ApiKeyStorage.API
import com.solux.flory.data.service.ApiKeyStorage.BOUQUET
import com.solux.flory.data.service.ApiKeyStorage.GIFT
import com.solux.flory.data.service.ApiKeyStorage.GIFT_ID
import com.solux.flory.data.service.ApiKeyStorage.V1
import com.solux.flory.domain.entity.BouquetDetailEntity
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface BouquetApiService {
    @GET("/$API/$V1/$GIFT/$BOUQUET")
    suspend fun getBouquetInfo(): BaseResponse<List<ResponseBouquetInfoDto>>

    @GET("/$API/$V1/$GIFT/${GIFT_ID}")
    suspend fun getBouquetDetail(
        @Path(GIFT_ID) giftId: Int,
        @Body requestBouquetDetailDto: RequestBouquetDetailDto
    ): Result<BaseResponse<BouquetDetailEntity>>
}