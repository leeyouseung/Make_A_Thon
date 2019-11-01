package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.model.report.ReportList

class ShowReportContentViewModel(application: Application) : BaseViewModel<ReportList>(application) {

    override fun onRetrieveDataSuccess(data: ReportList) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}