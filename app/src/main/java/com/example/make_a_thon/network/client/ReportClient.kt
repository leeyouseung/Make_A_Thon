package com.example.make_a_thon.network.client

import com.example.make_a_thon.base.BaseClient
import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.network.api.ReportApi

import io.reactivex.Single

class ReportClient : BaseClient<ReportApi>() {

    override fun type(): Class<ReportApi> {
        return ReportApi::class.java
    }

    fun getReport(token: String): Single<List<ReportList>> {
        return api.getReport(token).map(getResponseObjectsFunction())
    }
}