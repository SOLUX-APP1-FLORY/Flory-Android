package com.solux.flory.data.mapper

import com.solux.flory.data.dto.response.ResponseDiariesDto
import com.solux.flory.domain.entity.DiariesEntity

fun ResponseDiariesDto.toDiariesEntity() = DiariesEntity(
    flowerUrl
)