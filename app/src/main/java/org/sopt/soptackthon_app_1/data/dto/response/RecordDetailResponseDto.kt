package org.sopt.soptackthon_app_1.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecordDetailResponseDto(
    @SerialName("recordId")
    val recordId: Long,
    @SerialName("title")
    val title: String,
    @SerialName("photoUrl")
    val photoUrl: String? = null,
    @SerialName("isShared")
    val isShared: Boolean,
    @SerialName("createdAt")
    val createdAt: String
)
