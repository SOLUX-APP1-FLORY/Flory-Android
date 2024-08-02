package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBouquetDetailDto(
    @SerialName("letter_id") val letterId: Int,
    @SerialName("user_id") val userId: Int,
    @SerialName("sender") val sender: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("bouquet_imageUrl") val bouquetImageUrl: String,
    @SerialName("bouquet_name") val bouquetName: String,
    @SerialName("bouquet_meaning") val bouquetMeaning: String,
    @SerialName("content") val content: String,
)