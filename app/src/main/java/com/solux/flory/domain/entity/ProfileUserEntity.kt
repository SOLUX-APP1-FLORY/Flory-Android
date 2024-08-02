package com.solux.flory.domain.entity

data class ProfileUserEntity (
    val nickname: String,
    val email: String,
    val birthdate: String? = null,
    val gender: String,
)