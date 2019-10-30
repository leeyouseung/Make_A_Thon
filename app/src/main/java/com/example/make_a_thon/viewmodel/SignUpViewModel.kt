package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.network.client.SignClient
import com.example.make_a_thon.network.request.SignUpRequest
import com.example.make_a_thon.widget.SingleLiveEvent

class SignUpViewModel(application: Application) : BaseViewModel<Any>(application) {

    private val signClient = SignClient()

    val signUpEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<String>()
    val openLoginEvent = SingleLiveEvent<Unit>()

    var request = SignUpRequest()

    fun signUp() {
        addDisposable(signClient.signUp(request), baseObserver)
    }

    fun onClickSignUpBtn() {
        signUpEvent.call()
    }

    override fun onRetrieveDataSuccess(data: Any) {}

    override fun onRetrieveBaseSuccess(message: String) {
        onSuccessEvent.value = message
        openLoginEvent.call()
    }
}