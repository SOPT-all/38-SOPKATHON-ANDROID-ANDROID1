package org.sopt.soptackthon_app_1.presentation.yubin2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_1.data.network.ServicePool

class Yubin2ViewModel : ViewModel() {
    private val recordService = ServicePool.recordService
    private val _uiState = MutableStateFlow(Yubin2UiState())
    val uiState: StateFlow<Yubin2UiState> = _uiState.asStateFlow()

    fun getRecordDetail(recordId: Long) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val response = recordService.getRecordDetail(recordId)
                if (response.status in 200..299) {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            record = response.data
                        )
                    }
                } else {
                    _uiState.update { it.copy(isLoading = false, error = response.message) }
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
}
