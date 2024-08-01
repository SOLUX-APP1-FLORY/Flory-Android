package com.solux.flory.data.mapper

import com.solux.flory.data.dto.response.ResponseProfileDto
import com.solux.flory.domain.entity.ProfileUserEntity

fun ResponseProfileDto.toProfileUserEntity() = ProfileUserEntity(
    nickname, email, birthdate, gender
)