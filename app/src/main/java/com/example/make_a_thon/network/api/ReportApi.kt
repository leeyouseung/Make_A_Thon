package com.example.make_a_thon.network.api

import com.example.make_a_thon.model.report.Report
import com.example.make_a_thon.network.response.Response

import io.reactivex.Single

import okhttp3.MultipartBody
import okhttp3.RequestBody

import retrofit2.http.*

interface ReportApi {

    @Multipart
    @POST("/api/report")
    fun addReport(@Header("token") token: String?,
                  @Part("content") content: RequestBody?,
                  @Part image: MultipartBody.Part?): Single<retrofit2.Response<Response<Any>>>

    @GET("/api/report/data")
    fun getReportList(@Header("token") token: String): Single<retrofit2.Response<Response<List<Report>>>>

    @GET("/api/reportInfo/{id}")
    fun getReport(@Header("token") token: String, @Path("id") id: Int): Single<retrofit2.Response<Response<Report>>>
}