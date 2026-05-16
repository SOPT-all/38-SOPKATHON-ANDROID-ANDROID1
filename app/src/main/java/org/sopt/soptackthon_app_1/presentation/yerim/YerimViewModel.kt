package org.sopt.soptackthon_app_1.presentation.yerim

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_1.BuildConfig
import org.sopt.soptackthon_app_1.data.network.ServicePool

class YerimViewModel : ViewModel() {
    private val dummyService = ServicePool.dummyService

    private val _uiState = MutableStateFlow(YerimUiState())
    val uiState: StateFlow<YerimUiState> = _uiState.asStateFlow()

    fun getHomeRecords() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null,
                    isSuccess = false
                )
            }

            try {
                Log.d("YerimApi", "BASE_URL = ${BuildConfig.BASE_URL}")
                Log.d("YerimApi", "API 호출 시작")

                val response = dummyService.getHomeRecords()

                Log.d("YerimApi", "success = ${response.success}")
                Log.d("YerimApi", "status = ${response.status}")
                Log.d("YerimApi", "message = ${response.message}")
                Log.d("YerimApi", "records size = ${response.data.records.size}")

                _uiState.update {
                    it.copy(
                        records = response.data.records,
                        isLoading = false,
                        isSuccess = response.success,
                        error = null
                    )
                }
            } catch (e: Exception) {
                Log.e("YerimApi", "API 호출 실패", e)

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = e.message ?: "노하우 카드 조회 실패"
                    )
                }
            }
        }
    }
}