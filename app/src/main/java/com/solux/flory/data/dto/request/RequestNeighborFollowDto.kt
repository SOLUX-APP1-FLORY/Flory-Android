package com.solux.flory.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestNeighborFollowDto (
    @SerialName("targetUserNickname") val targetUserNickname: String
)