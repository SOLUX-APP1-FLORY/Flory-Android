package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseProfileDto(
    @SerialName("userId") val userId: String,
    @SerialName("nickname") val nickname: String,
    @SerialName("email") val email: String,
    @SerialName("birthdate") val birthdate: String,
    @SerialName("gender") val gender: String,
    @SerialName("createdAt") val createdAt: String
)