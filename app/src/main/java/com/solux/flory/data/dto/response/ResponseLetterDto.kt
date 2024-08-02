package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseLetterDto (
    @SerialName("message") val message: String
)