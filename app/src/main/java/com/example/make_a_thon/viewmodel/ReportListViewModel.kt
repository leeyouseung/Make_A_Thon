package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.model.report.Report
import com.example.make_a_thon.network.client.ReportClient
import com.example.make_a_thon.widget.recyclerview.adapter.ReportAdapter

class ReportListViewModel(application: Application) : BaseViewModel<List<Report>>(application) {

    private val reportClient = ReportClient()

    var reportAdapter = ReportAdapter()

    fun getReportList() {
        addDisposable(reportClient.getReportList(token), dataObserver)
    }

    override fun onRetrieveDataSuccess(data: List<Report>) {
        reportAdapter.updateList(data)
    }

    override fun onRetrieveBaseSuccess(message: String) {}
}