package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignUpDto(
    @SerialName("userId") val userId: Int,
    @SerialName("createdAt") val createdAt: String,
)