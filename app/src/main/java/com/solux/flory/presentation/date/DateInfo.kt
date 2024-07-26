package com.solux.flory.presentation.date

import java.io.Serializable

data class DateInfo(
    var year: Int = 0,
    var month: Int = 0,
    var dayOfMonth: Int = 0,
    var imageUrl: String? = null
) : Serializable
