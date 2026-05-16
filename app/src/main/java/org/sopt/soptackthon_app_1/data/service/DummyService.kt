package org.sopt.soptackthon_app_1.data.service

import org.sopt.soptackthon_app_1.data.dto.base.BaseResponse
import org.sopt.soptackthon_app_1.data.dto.request.DummyRequestDto
import org.sopt.soptackthon_app_1.data.dto.response.DummyResponseDto
import org.sopt.soptackthon_app_1.data.dto.response.YerimResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DummyService {
    @GET("api/v1/data")
    suspend fun getExampleData(): BaseResponse<DummyResponseDto>

    @POST("api/v1/data")
    suspend fun postExampleData(
        @Body exampleRequestDto: DummyRequestDto,
    ): BaseResponse<Unit>

    @GET("/api/v1/records/")
    suspend fun getHomeRecords(): YerimResponseDto
}
