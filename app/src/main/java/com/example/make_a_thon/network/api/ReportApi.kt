package com.example.make_a_thon.network.api

import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.network.response.Response

import io.reactivex.Single

import retrofit2.http.*

interface ReportApi {

    @GET("/api/report/data")
    fun getReportList(@Header("token") token: String): Single<retrofit2.Response<Response<List<ReportList>>>>

//    @GET("/api/reportInfo/{id}")
//    fun getReport(@Header("token") token: String, @Path("id") id: Int): Single<retrofit2.Response<Response<ReportList>>>
}