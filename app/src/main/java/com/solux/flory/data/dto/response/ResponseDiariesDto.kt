package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDiariesDto (
    @SerialName("flowerUrl") val flowerUrl: String,
    @SerialName("createdAt") val createdAt: String,
)