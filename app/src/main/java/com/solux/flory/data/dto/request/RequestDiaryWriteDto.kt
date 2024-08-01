package com.solux.flory.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestDiaryWriteDto (
    @SerialName("flower") val flower: String,
    @SerialName("title") val title: String,
    @SerialName("content") val content: String,
)