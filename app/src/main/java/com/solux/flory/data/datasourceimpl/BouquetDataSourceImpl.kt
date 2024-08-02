package com.solux.flory.data.datasourceimpl

import com.solux.flory.data.datasource.BouquetDataSource
import com.solux.flory.data.dto.BaseResponse
import com.solux.flory.data.dto.request.RequestBouquetDetailDto
import com.solux.flory.data.dto.response.ResponseBouquetDetailDto
import com.solux.flory.data.dto.response.ResponseBouquetInfoDto
import com.solux.flory.data.service.BouquetApiService
import com.solux.flory.domain.entity.BouquetDetailEntity
import javax.inject.Inject

class BouquetDataSourceImpl @Inject constructor(
    private val bouquetApiService: BouquetApiService
): BouquetDataSource{
    override suspend fun getBouquetInfo(): BaseResponse<List<ResponseBouquetInfoDto>> {
        return bouquetApiService.getBouquetInfo()
    }

    override suspend fun getBouquetDetail(
        giftId: Int,
        requestBouquetDetailDto: RequestBouquetDetailDto
    ): BaseResponse<BouquetDetailEntity> {
        return bouquetApiService.getBouquetDetail(giftId, requestBouquetDetailDto)
    }
}
