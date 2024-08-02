package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBouquetInfoDto(
    @SerialName("id") val id: Int,
    @SerialName("sender") val sender: String,
    @SerialName("bouquetId") val bouquetId: Int,
)