package com.example.make_a_thon.network.api

import com.example.make_a_thon.network.response.Response

import io.reactivex.Single

import okhttp3.MultipartBody
import okhttp3.RequestBody

import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST

interface ReportApi {

    @Multipart
    @POST("/report")
    fun report(@Header("Authorization") token: String,
                 @retrofit2.http.Part picture: MultipartBody.Part,
                 @retrofit2.http.Part("content") content: RequestBody): Single<retrofit2.Response<Response<Any>>>
}