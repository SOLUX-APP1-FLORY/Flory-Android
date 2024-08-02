package com.solux.flory.domain.entity

data class DiaryViewEntity (
    val diaryId: Int,
    val flowerName: String,
    val flowerMeaning: String,
    val title: String,
    val content: String,
    val flowerImageUrl: String,
)