package com.example.make_a_thon.network.client

import com.example.make_a_thon.base.BaseClient
import com.example.make_a_thon.model.report.Report
import com.example.make_a_thon.network.api.ReportApi

import io.reactivex.Single

class ReportClient : BaseClient<ReportApi>() {

    override fun type(): Class<ReportApi> {
        return ReportApi::class.java
    }

//    fun addReport(token: String, content: String): Single<Report> {
//        return api.addReport(token, content).map(getResponseMessageFunction())
//    }

    fun getReportList(token: String): Single<List<Report>> {
        return api.getReportList(token).map(getResponseObjectsFunction())
    }
}