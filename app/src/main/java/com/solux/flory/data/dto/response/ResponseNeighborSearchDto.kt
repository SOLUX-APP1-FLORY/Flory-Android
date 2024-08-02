package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseNeighborSearchDto (
    @SerialName("userId") val userId: String,
    @SerialName("nickname") val nickname: String,
)