package com.solux.flory.data.datasource

import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestBouquetDetailDto
import com.solux.flory.data.dto.response.ResponseBouquetDetailDto
import com.solux.flory.data.dto.response.ResponseBouquetInfoDto
import com.solux.flory.domain.entity.BouquetDetailEntity

interface BouquetDataSource {
    suspend fun getBouquetInfo(): BaseResponse<List<ResponseBouquetInfoDto>>
    suspend fun getBouquetDetail(giftId: Int, requestBouquetDetailDto: RequestBouquetDetailDto): BaseResponse<BouquetDetailEntity>
}