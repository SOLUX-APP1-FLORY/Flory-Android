package com.solux.flory.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBouquetInfoDto(
    @SerialName("giftId") val giftId: Int,
    @SerialName("sender") val sender: String,
    @SerialName("bouquetId") val bouquetId: Int,
    @SerialName("bouquetUrl") val bouquetUrl: String,
)