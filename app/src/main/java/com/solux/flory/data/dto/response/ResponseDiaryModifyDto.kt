package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDiaryModifyDto (
    @SerialName("diary_id") val diaryId: Int,
    @SerialName("flower_id") val flowerId: Int,
    @SerialName("flower") val flower: String,
    @SerialName("flower_meaning") val flowerMeaning: String,
    @SerialName("title") val title: String,
    @SerialName("content") val content: String,
    @SerialName("createdAt") val createdAt: String,
    @SerialName("updatedAt") val updatedAt: String? = null,
)