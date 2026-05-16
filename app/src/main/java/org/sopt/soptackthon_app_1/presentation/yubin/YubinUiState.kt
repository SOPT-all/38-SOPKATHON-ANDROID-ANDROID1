package org.sopt.soptackthon_app_1.presentation.yubin

data class YubinUiState(
    val title: String = "",
    //변수들 추가해주세용
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
) {

}
