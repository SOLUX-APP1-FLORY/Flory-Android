package com.solux.flory.data.mapper

import com.solux.flory.data.dto.response.ResponseBouquetInfoDto
import com.solux.flory.domain.entity.BouquetInfoEntity

fun ResponseBouquetInfoDto.toBouquetInfoEntity() = BouquetInfoEntity(
    id, sender, bouquetId
)