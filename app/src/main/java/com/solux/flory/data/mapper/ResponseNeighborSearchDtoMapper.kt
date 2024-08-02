package com.solux.flory.data.mapper

import com.solux.flory.data.dto.response.ResponseNeighborSearchDto
import com.solux.flory.domain.entity.NeighborSearchEntity

fun ResponseNeighborSearchDto.toNeighborSearchEntity() = NeighborSearchEntity(
    userId, nickname
)