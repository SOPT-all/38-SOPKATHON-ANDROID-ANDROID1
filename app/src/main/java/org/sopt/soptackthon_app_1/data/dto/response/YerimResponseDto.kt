package org.sopt.soptackthon_app_1.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class YerimResponseDto(
    val success: Boolean,
    val status: Int,
    val message: String,
    val data: Data
) {
    @Serializable
    data class Data(
        val records: List<Record>
    )

    @Serializable
    data class Record(
        val recordId: Long,
        val author: Author,
        val title: String,
        val photoUrl: String?,
        val voiceDurationSeconds: Int?,
        val createdAt: String
    )

    @Serializable
    data class Author(
        val name: String,
        val age: Int,
        val profileImageUrl: String
    )
}