package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel

class ReportListViewModel(application: Application) : BaseViewModel<ReportListViewModel>(application) {

    override fun onRetrieveDataSuccess(data: ReportListViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}