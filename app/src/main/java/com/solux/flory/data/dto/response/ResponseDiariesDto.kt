package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDiariesDto (
    @SerialName("flowerUrl") val flowerUrl: String? = null,
    @SerialName("createdAt") val createdAt: String? = null,
)