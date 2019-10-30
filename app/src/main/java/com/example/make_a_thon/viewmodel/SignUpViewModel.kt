package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel

class SignUpViewModel(application: Application) : BaseViewModel<SignUpViewModel>(application) {

    override fun onRetrieveDataSuccess(data: SignUpViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}