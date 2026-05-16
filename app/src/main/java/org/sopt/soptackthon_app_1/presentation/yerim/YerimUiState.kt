package org.sopt.soptackthon_app_1.presentation.yerim

data class YerimUiState(
    val title: String = "",
    //변수들 추가해주세용
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
) {

}
