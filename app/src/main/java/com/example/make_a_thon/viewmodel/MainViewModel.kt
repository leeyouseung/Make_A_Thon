package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.widget.SingleLiveEvent

class MainViewModel(application: Application) : BaseViewModel<MainViewModel>(application) {

    val myPlaceSetEvent = SingleLiveEvent<Unit>()

    fun onClickMyPlaceSetBtn() {
        myPlaceSetEvent.call()
    }

    override fun onRetrieveDataSuccess(data: MainViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}