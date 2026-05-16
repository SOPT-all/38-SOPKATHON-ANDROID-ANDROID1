package org.sopt.soptackthon_app_1.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecordCreateResponseDto(
    @SerialName("recordId")
    val recordId: Long,
    @SerialName("title")
    val title: String,
    @SerialName("photoUrl")
    val photoUrl: String? = null,
    @SerialName("voiceDurationSeconds")
    val voiceDurationSeconds: Int? = null,
    @SerialName("isShared")
    val isShared: Boolean,
    @SerialName("location")
    val location: String,
    @SerialName("createdAt")
    val createdAt: String
)
