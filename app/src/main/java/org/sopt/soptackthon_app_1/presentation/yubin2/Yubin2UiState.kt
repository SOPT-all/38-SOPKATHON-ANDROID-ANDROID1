package org.sopt.soptackthon_app_1.presentation.yubin2

import org.sopt.soptackthon_app_1.data.dto.response.RecordDetailResponseDto

data class Yubin2UiState(
    val record: RecordDetailResponseDto? = null,
    val formattedDate: String = "5월 14일",
    val formattedTime: String = "16:50",
    val isLoading: Boolean = false,
    val error: String? = null,
)
