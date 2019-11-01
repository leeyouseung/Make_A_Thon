package com.example.make_a_thon.network.api

import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.network.response.Response

import io.reactivex.Single

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface ReportApi {

    @Multipart
    @POST("/api/report")
    fun report(@Header("token") token: String,
               @Part image: MultipartBody.Part,
               @Part content: RequestBody): Single<retrofit2.Response<Response<Any>>>

    @GET("/api/report")
    fun getReport(@Header("token") token: String): Single<retrofit2.Response<Response<List<ReportList>>>>
}