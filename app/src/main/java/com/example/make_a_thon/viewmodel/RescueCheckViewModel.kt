package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel

class RescueCheckViewModel(application: Application) : BaseViewModel<RescueCheckViewModel>(application) {

    override fun onRetrieveDataSuccess(data: RescueCheckViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}