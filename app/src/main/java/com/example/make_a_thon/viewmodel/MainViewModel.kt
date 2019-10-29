package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.flut_fluss_kotlin.base.viewmodel.BaseViewModel

class MainViewModel(application: Application) : BaseViewModel<MainViewModel>(application) {

    override fun onRetrieveDataSuccess(data: MainViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}