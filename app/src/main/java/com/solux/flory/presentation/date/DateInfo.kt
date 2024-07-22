package com.solux.flory.presentation.date

import java.io.Serializable

data class DateInfo(
    var month: Int = 0,
    var dayOfWeek: Int = 0,
) : Serializable
