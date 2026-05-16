package org.sopt.soptackthon_app_1.presentation.gabyu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_1.data.network.ServicePool
import java.util.Calendar

class GabyuViewModel : ViewModel() {
    private val recordService = ServicePool.recordService

    private val _uiState = MutableStateFlow<GabyuUiState>(GabyuUiState.Loading)
    val uiState: StateFlow<GabyuUiState> = _uiState.asStateFlow()

    init {
        getCalendar(2026, 5)
    }

    fun getCalendar(year: Int, month: Int) {
        viewModelScope.launch {
            _uiState.value = GabyuUiState.Loading
            runCatching {
                recordService.getCalendar(year, month)
            }.onSuccess { response ->
                if (response.success) {
                    val data = response.data
                    val fullGridDays = createCalendarGrid(year, month, data.days.map { 
                        CalendarDayUiModel(it.day, it.recordId, it.thumbnailUrl)
                    })
                    
                    _uiState.value = GabyuUiState.Success(
                        fullGridDays = fullGridDays,
                        info = CalendarInfoUiModel(
                            year = data.year,
                            month = data.month,
                            recordCount = data.recordCount,
                            sharedCount = data.sharedCount
                        )
                    )
                } else {
                    _uiState.value = GabyuUiState.Error(response.message)
                }
            }.onFailure {
                _uiState.value = GabyuUiState.Error(it.message ?: "캘린더 조회 실패")
            }
        }
    }

    private fun createCalendarGrid(year: Int, month: Int, records: List<CalendarDayUiModel>): List<CalendarDayUiModel> {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month - 1)
            set(Calendar.DAY_OF_MONTH, 1)
        }

        val startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) // 1: Sun, 2: Mon, ...
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        val grid = mutableListOf<CalendarDayUiModel>()

        // Pad start
        for (i in 1 until startDayOfWeek) {
            grid.add(CalendarDayUiModel(null))
        }

        // Fill days
        for (day in 1..daysInMonth) {
            val record = records.find { it.day == day }
            grid.add(record ?: CalendarDayUiModel(day))
        }

        return grid
    }
}
