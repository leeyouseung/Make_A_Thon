package com.example.make_a_thon.viewmodel

import android.app.Application

import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.network.client.UserClient
import com.example.make_a_thon.widget.SingleLiveEvent

class ProFileViewModel(application: Application) : BaseViewModel<ProFileViewModel>(application) {

    private val userClient = UserClient()

    var id: MutableLiveData<String> = MutableLiveData()

    val myPlaceSetEvent = SingleLiveEvent<Unit>()
    val reportListEvent = SingleLiveEvent<Unit>()

    var userName = MutableLiveData<String>()

    fun onClickMyPlaceSetBtn() {
        myPlaceSetEvent.call()
    }

    fun onClickReportListBtn() {
        reportListEvent.call()
    }

    fun setUp() {
        getProfile()
    }

    private fun getProfile() {
        addDisposableLoading(userClient.getProfile(token, id.value!!), dataObserver)
    }

    override fun onRetrieveDataSuccess(data: ProFileViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}