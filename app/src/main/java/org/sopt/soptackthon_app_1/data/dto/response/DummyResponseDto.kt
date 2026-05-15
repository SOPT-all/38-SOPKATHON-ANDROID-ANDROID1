package org.sopt.soptackthon_app_1.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class DummyResponseDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
)
