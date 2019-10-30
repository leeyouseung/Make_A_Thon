package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel

class LoginViewModel(application: Application) : BaseViewModel<LoginViewModel>(application) {

    override fun onRetrieveDataSuccess(data: LoginViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}