package org.sopt.soptackthon_app_1.presentation.gabyu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.soptackthon_app_1.data.network.ServicePool
import org.sopt.soptackthon_app_1.presentation.yerim.YerimUiState

class GabyuViewModel : ViewModel() {
    private val DummyService = ServicePool.dummyService
    private val _uiState = MutableStateFlow(YerimUiState())
    val uiState: StateFlow<YerimUiState> = _uiState.asStateFlow()

    private fun dummy() {
        viewModelScope.launch {
            //request 는 따로 데이터 담아서 보내면 되고, 이런식으로 service 객체에서 함수 뽑아 쓰면 됩니다
            // val response = exampleService.postExampleData(request)

            try {

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = e.message ?: "example failed"
                    )
                }
            }
        }
    }
}
