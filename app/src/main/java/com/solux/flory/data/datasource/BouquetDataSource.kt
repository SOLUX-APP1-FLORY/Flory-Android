package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.response.ResponseBouquetDetailDto
import com.solux.flory.data.dto.response.ResponseBouquetInfoDto

interface BouquetDataSource {
    suspend fun getBouquetInfo(): BaseResponse<List<ResponseBouquetInfoDto>>
    suspend fun getBouquetDetail(giftId: Int): BaseResponse<ResponseBouquetDetailDto>
}