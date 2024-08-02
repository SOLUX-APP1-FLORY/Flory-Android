package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserInfoDto (
    @SerialName("uid") val uid: String = "",
    @SerialName("nickname") val nickname: String = "",
    @SerialName("email") val email: String = "",
    @SerialName("gender") val gender: String = "",
    @SerialName("createdAt") val createdAt: String = "",
    @SerialName("updatedAt") val updatedAt: String? = "",
)