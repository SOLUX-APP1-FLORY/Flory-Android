package com.solux.flory.data.mapper

import com.solux.flory.data.dto.response.ResponseDiaryViewDto
import com.solux.flory.domain.entity.DiaryViewEntity

fun ResponseDiaryViewDto.toDiaryViewEntity() = DiaryViewEntity(
    diaryId, flowerName, flowerMeaning, title, content, flowerImageUrl
)