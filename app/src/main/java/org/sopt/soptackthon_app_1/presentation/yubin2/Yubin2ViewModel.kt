package org.sopt.soptackthon_app_1.presentation.yubin2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_1.data.dto.response.RecordDetailResponseDto

class Yubin2ViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(Yubin2UiState())
    val uiState: StateFlow<Yubin2UiState> = _uiState.asStateFlow()

    fun getRecordDetail(recordId: Long) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                // 임시 데이터 (나중에 실제 API 결과로 대체)
                val mockRecord = RecordDetailResponseDto(
                    recordId = recordId,
                    title = "상추 모종 심기",
                    photoUrl = null,
                    isShared = false,
                    createdAt = "2026-05-14T16:19:02+09:00"
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        record = mockRecord,
                        formattedDate = formatToDate(mockRecord.createdAt),
                        formattedTime = formatToTime(mockRecord.createdAt)
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "데이터를 불러오는데 실패했습니다."
                    )
                }
            }
        }
    }

    private fun formatToDate(createdAt: String): String {
        return try {
            val datePart = createdAt.split("T")[0] // "2026-05-14"
            val parts = datePart.split("-")
            "${parts[1].toInt()}월 ${parts[2].toInt()}일"
        } catch (e: Exception) {
            ""
        }
    }

    private fun formatToTime(createdAt: String): String {
        return try {
            val timePart = createdAt.split("T")[1].split("+")[0] // "16:19:02"
            val hourMin = timePart.split(":")
            "${hourMin[0]}:${hourMin[1]}" // "16:19"
        } catch (e: Exception) {
            ""
        }
    }
}
