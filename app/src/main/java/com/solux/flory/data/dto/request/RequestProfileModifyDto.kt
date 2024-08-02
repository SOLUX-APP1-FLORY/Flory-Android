package com.solux.flory.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestProfileModifyDto (
    @SerialName("nickname") val nickname: String,
    @SerialName("gender") val gender: String,
    @SerialName("birthdate") val birthdate: String,
)