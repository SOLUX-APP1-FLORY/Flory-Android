package com.solux.flory.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLetterDto (
    @SerialName("flowerName") val flowerName: String,
    @SerialName("receiverNickname") val receiverNickname: String,
    @SerialName("content") val content: String
)