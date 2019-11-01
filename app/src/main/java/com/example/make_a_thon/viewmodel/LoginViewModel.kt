package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.network.client.SignClient
import com.example.make_a_thon.network.request.LoginRequest
import com.example.make_a_thon.network.response.data.LoginData
import com.example.make_a_thon.widget.SingleLiveEvent

class LoginViewModel(application: Application) : BaseViewModel<LoginData>(application) {

    private val signClient = SignClient()

    val loginEvent = SingleLiveEvent<Unit>()
    val signUpEvent = SingleLiveEvent<Unit>()

    val openMain = SingleLiveEvent<Unit>()

    var request = LoginRequest()

    fun login() {
        addDisposable(signClient.login(request), dataObserver)
    }

    fun onClickLoginBtn() {
        loginEvent.call()
    }

    fun onClickSignUpBtn() {
        signUpEvent.call()
    }

    override fun onRetrieveDataSuccess(data: LoginData) {}

    override fun onRetrieveBaseSuccess(message: String) {
        if(message == "success") {
            openMain.call()
        }
        else {
            return
        }
    }
}