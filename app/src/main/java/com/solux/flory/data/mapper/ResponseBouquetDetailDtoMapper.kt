package com.solux.flory.data.mapper

import com.solux.flory.data.dto.response.ResponseBouquetDetailDto
import com.solux.flory.domain.entity.BouquetDetailEntity

fun ResponseBouquetDetailDto.toBouquetDetailEntity() = BouquetDetailEntity(
    sender, createdAt, bouquetImageUrl, content
)