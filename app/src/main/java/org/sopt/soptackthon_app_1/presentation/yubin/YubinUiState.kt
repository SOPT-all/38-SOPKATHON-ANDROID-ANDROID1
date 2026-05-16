package org.sopt.soptackthon_app_1.presentation.yubin

import android.net.Uri

data class YubinUiState(
    val title: String = "",
    val imageUri: Uri? = null,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val recordId: Long? = null,
    val error: String? = null,
)
