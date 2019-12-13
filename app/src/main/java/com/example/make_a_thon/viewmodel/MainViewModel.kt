package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.widget.SingleLiveEvent

class MainViewModel(application: Application) : BaseViewModel<Any>(application) {

    val sosEvent = SingleLiveEvent<Unit>()
    val myPlaceSetEvent = SingleLiveEvent<Unit>()
    val cctvCheckEvent = SingleLiveEvent<Unit>()
    val callEvent = SingleLiveEvent<Unit>()

    fun onClickSosBtn() {
        sosEvent.call()
    }

    fun onClickMyPlaceSetBtn() {
        myPlaceSetEvent.call()
    }

    fun onClickCctvBtn() {
        cctvCheckEvent.call()
    }

    fun onClickCallBtn() {
        callEvent.call()
    }

    override fun onRetrieveDataSuccess(data: Any) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}