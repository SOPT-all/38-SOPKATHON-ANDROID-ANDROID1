package org.sopt.soptackthon_app_1.presentation.yubin2

import org.sopt.soptackthon_app_1.data.dto.response.RecordDetailResponseDto

data class Yubin2UiState(
    val record: RecordDetailResponseDto? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
