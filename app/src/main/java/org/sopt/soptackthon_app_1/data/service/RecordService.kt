package org.sopt.soptackthon_app_1.data.service

import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.sopt.soptackthon_app_1.data.dto.base.BaseResponse
import org.sopt.soptackthon_app_1.data.dto.response.CalendarResponseDto
import org.sopt.soptackthon_app_1.data.dto.response.RecordCreateResponseDto
import org.sopt.soptackthon_app_1.data.dto.response.RecordDetailResponseDto
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface RecordService {
    @Multipart
    @POST("api/v1/records")
    suspend fun postRecord(
        @Part("title") title: RequestBody,
        @Part photo: MultipartBody.Part?,
        @Part("voiceDurationSeconds") voiceDurationSeconds: RequestBody?,
        @Part("isShared") isShared: RequestBody,
        @Part("location") location: RequestBody,
        @Part("recordedAt") recordedAt: RequestBody
    ): BaseResponse<RecordCreateResponseDto>

    @GET("api/v1/records/{recordId}")
    suspend fun getRecordDetail(
        @Path("recordId") recordId: Long
    ): BaseResponse<RecordDetailResponseDto>

    @GET("api/v1/me/records/calendar")
    suspend fun getCalendar(
        @Query("year") year: Int,
        @Query("month") month: Int
    ): BaseResponse<CalendarResponseDto>
}
