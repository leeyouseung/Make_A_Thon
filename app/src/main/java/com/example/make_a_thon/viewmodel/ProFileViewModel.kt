package com.example.make_a_thon.viewmodel

import android.app.Application

import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.model.user.Profile
import com.example.make_a_thon.network.client.UserClient
import com.example.make_a_thon.widget.SingleLiveEvent

class ProFileViewModel(application: Application) : BaseViewModel<Profile>(application) {

    private val userClient = UserClient()

    val myPlaceSetEvent = SingleLiveEvent<Unit>()
    val reportListEvent = SingleLiveEvent<Unit>()

    var userName = MutableLiveData<String>()
    var userPlace = MutableLiveData<String>()

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
        addDisposable(userClient.getProfile(token), dataObserver)
    }

    override fun onRetrieveDataSuccess(data: Profile) {
        userName.value = data.name
        userPlace.value = data.place
    }

    override fun onRetrieveBaseSuccess(message: String) {}
}