package org.sopt.soptackthon_app_1.presentation.yerim

import org.sopt.soptackthon_app_1.data.dto.response.YerimResponseDto

data class YerimUiState(
    val records: List<YerimResponseDto.Record> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
)

