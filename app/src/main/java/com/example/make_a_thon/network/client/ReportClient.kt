package com.example.make_a_thon.network.client

import com.example.make_a_thon.base.BaseClient
import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.network.api.ReportApi

import io.reactivex.Single

import okhttp3.MultipartBody
import okhttp3.RequestBody

class ReportClient : BaseClient<ReportApi>() {

    fun report(token: String, picture: MultipartBody.Part, content: RequestBody): Single<String> {
        return api.report(token, picture, content).map(getResponseMessageFunction())
    }

    fun getReport(token: String): Single<List<ReportList>> {
        return api.getReport(token).map(getResponseObjectsFunction())
    }

    override fun type(): Class<ReportApi> {
        return ReportApi::class.java
    }
}