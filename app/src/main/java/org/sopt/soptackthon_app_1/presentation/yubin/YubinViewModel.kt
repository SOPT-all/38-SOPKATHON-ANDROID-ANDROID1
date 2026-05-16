package org.sopt.soptackthon_app_1.presentation.yubin

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.sopt.soptackthon_app_1.data.network.ServicePool
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class YubinViewModel : ViewModel() {
    private val recordService = ServicePool.recordService
    private val _uiState = MutableStateFlow(YubinUiState())
    val uiState: StateFlow<YubinUiState> = _uiState.asStateFlow()

    fun updateTitle(title: String) {
        _uiState.update { it.copy(title = title) }
    }

    fun updateImageUri(uri: Uri?) {
        _uiState.update { it.copy(imageUri = uri) }
    }

    fun postRecord(context: Context, isShared: Boolean = false) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val titleBody = _uiState.value.title.toRequestBody("text/plain".toMediaTypeOrNull())
                val isSharedBody = isShared.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                val locationBody = "서울시 마포구 망원동".toRequestBody("text/plain".toMediaTypeOrNull())
                
                // 현재 시간을 ISO-8601 형식으로 생성
                val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault())
                val recordedAtBody = sdf.format(Date()).toRequestBody("text/plain".toMediaTypeOrNull())
                
                // 음성 녹음 길이는 임시로 30초
                val durationBody = "30".toRequestBody("text/plain".toMediaTypeOrNull())

                val photoPart = _uiState.value.imageUri?.let { uri ->
                    val file = uriToFile(context, uri)
                    val requestFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
                    MultipartBody.Part.createFormData("photo", file.name, requestFile)
                }

                val response = recordService.postRecord(
                    title = titleBody,
                    photo = photoPart,
                    voiceDurationSeconds = durationBody,
                    isShared = isSharedBody,
                    location = locationBody,
                    recordedAt = recordedAtBody
                )

                if (response.success) {
                    _uiState.update { 
                        it.copy(
                            isLoading = false, 
                            isSuccess = true,
                            recordId = response.data.recordId
                        ) 
                    }
                } else {
                    _uiState.update { it.copy(isLoading = false, error = response.message) }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "요청에 실패했습니다."
                    )
                }
            }
        }
    }

    fun shareToBoard(context: Context) {
        postRecord(context, isShared = true)
    }

    fun resetState() {
        _uiState.value = YubinUiState()
    }

    private fun uriToFile(context: Context, uri: Uri): File {
        val inputStream = context.contentResolver.openInputStream(uri)
        val originalBitmap = BitmapFactory.decodeStream(inputStream)
        inputStream?.close()

        val file = File(context.cacheDir, "upload_image.jpg")
        val outputStream = FileOutputStream(file)
        
        // 퀄리티를 80% 정도로 압축하여 용량을 획기적으로 줄임
        originalBitmap?.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
        outputStream.flush()
        outputStream.close()

        return file
    }
}
