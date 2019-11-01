package com.example.make_a_thon.network.api

import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.network.response.Response

import io.reactivex.Single

import okhttp3.MultipartBody.Part
import okhttp3.RequestBody

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST

interface ReportApi {

    @Multipart
    @POST("/api/report")
    fun report(@Header("token") token: String,
               @retrofit2.http.Part image: Part,
               @retrofit2.http.Part content: RequestBody): Single<retrofit2.Response<Response<Any>>>

    @GET("/api/report")
    fun getReport(@Header("token") token: String): Single<retrofit2.Response<Response<List<ReportList>>>>
}