package org.sopt.soptackthon_app_1.presentation.yubin

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class YubinViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(YubinUiState())
    val uiState: StateFlow<YubinUiState> = _uiState.asStateFlow()

    fun updateTitle(title: String) {
        _uiState.update { it.copy(title = title) }
    }

    fun updateImageUri(uri: Uri?) {
        _uiState.update { it.copy(imageUri = uri) }
    }

    fun postRecord() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                // TODO: 실제 API 연결 시 multipart 등으로 이미지 전송 로직 구현
                // val response = service.postRecord(title = _uiState.value.title, image = ...)
                
                _uiState.update { it.copy(isLoading = false, isSuccess = true) }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = false,
                        error = e.message ?: "저장에 실패했습니다."
                    )
                }
            }
        }
    }
}
