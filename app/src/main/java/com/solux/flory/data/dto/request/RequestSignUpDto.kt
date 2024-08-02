package com.solux.flory.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUpDto(
    @SerialName("user-id") val id: String,
    @SerialName("user-password") val password: String,
    @SerialName("user-email") val email: String,
)