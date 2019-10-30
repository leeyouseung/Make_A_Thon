package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel

class MyPlaceViewModel(application: Application) : BaseViewModel<MyPlaceViewModel>(application) {

    override fun onRetrieveDataSuccess(data: MyPlaceViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}