package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel

class CCTVViewModel(application: Application) : BaseViewModel<CCTVViewModel>(application) {

    override fun onRetrieveDataSuccess(data: CCTVViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}