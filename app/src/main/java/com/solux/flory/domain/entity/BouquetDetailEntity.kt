package com.solux.flory.domain.entity

data class BouquetDetailEntity(
    //유저 이름 추가
    val sender: String? = null,
    val createdAt: String,
    val bouquetImageUrl: String,
    val content: String,
)
