package com.solux.flory.domain.entity

data class BouquetInfoEntity (
    val giftId: Int,
    val sender: String? = null,
    val bouquetId: Int,
    val bouquetUrl: String,
)