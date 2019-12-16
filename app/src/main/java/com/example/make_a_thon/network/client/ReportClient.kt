package com.example.make_a_thon.network.client

import com.example.make_a_thon.base.BaseClient
import com.example.make_a_thon.model.report.Report
import com.example.make_a_thon.network.api.ReportApi

import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody

class ReportClient : BaseClient<ReportApi>() {

    override fun type(): Class<ReportApi> {
        return ReportApi::class.java
    }

    fun addReport(token: String,
                  content: RequestBody,
                  image: MultipartBody.Part): Single<Any> {
        return api.addReport(token, content, image).map(getResponseMessageFunction())
    }

    fun getReportList(token: String): Single<List<Report>> {
        return api.getReportList(token).map(getResponseObjectsFunction())
    }
}