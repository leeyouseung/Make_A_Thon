package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel

class ProFileViewModel(application: Application) : BaseViewModel<ProFileViewModel>(application) {

    override fun onRetrieveDataSuccess(data: ProFileViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}