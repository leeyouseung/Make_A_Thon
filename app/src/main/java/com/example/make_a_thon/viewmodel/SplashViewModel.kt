package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.flut_fluss_kotlin.base.viewmodel.BaseViewModel

class SplashViewModel(application: Application) : BaseViewModel<SplashViewModel>(application) {

    override fun onRetrieveDataSuccess(data: SplashViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}