package org.sopt.soptackthon_app_1.presentation.gabyu

sealed interface GabyuUiState {
    data object Loading : GabyuUiState
    data class Success(
        val fullGridDays: List<CalendarDayUiModel>,
        val info: CalendarInfoUiModel
    ) : GabyuUiState
    data class Error(val message: String) : GabyuUiState
}

data class CalendarInfoUiModel(
    val year: Int,
    val month: Int,
    val recordCount: Int,
    val sharedCount: Int
)

data class CalendarDayUiModel(
    val day: Int?,
    val recordId: Long? = null,
    val thumbnailUrl: String? = null
)
