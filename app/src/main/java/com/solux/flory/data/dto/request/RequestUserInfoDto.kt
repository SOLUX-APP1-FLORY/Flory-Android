package com.solux.flory.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestUserInfoDto(
    @SerialName("id") val id: Int,
    @SerialName("nickname") val nickname: String,
    @SerialName("gender") val gender: String,
)