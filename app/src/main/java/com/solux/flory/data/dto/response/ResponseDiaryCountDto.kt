package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDiaryCountDto (
    @SerialName("count") val count: Int = 0,
)