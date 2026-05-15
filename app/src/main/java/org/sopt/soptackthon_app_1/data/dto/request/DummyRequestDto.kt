package org.sopt.soptackthon_app_1.data.dto.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyRequestDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
)
