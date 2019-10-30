package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel

class ReportViewModel(application: Application) : BaseViewModel<ReportViewModel>(application) {

    override fun onRetrieveDataSuccess(data: ReportViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}