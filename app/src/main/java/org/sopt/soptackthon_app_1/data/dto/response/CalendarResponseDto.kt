package org.sopt.soptackthon_app_1.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CalendarResponseDto(
    @SerialName("year")
    val year: Int,
    @SerialName("month")
    val month: Int,
    @SerialName("recordCount")
    val recordCount: Int,
    @SerialName("sharedCount")
    val sharedCount: Int,
    @SerialName("days")
    val days: List<CalendarDayDto>
)

@Serializable
data class CalendarDayDto(
    @SerialName("day")
    val day: Int,
    @SerialName("recordId")
    val recordId: Long,
    @SerialName("thumbnailUrl")
    val thumbnailUrl: String? = null
)
