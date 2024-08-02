package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDiaryViewDto (
    @SerialName("diary_id") val diaryId: Int,
    @SerialName("user_id") val userId: Int,
    @SerialName("flower_id") val flowerId: Int,
    @SerialName("created_at") val createdAt: String,
    @SerialName("flower_name") val flowerName: String,
    @SerialName("flower_meaning") val flowerMeaning: String,
    @SerialName("title") val title: String,
    @SerialName("content") val content: String,
    @SerialName("flower_imageUrl") val flowerImageUrl: String,
)