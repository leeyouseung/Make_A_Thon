package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.model.user.User
import com.example.make_a_thon.network.client.SignClient
import com.example.make_a_thon.network.request.LoginRequest
import com.example.make_a_thon.network.response.data.LoginData
import com.example.make_a_thon.widget.SingleLiveEvent

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(application: Application) : BaseViewModel<LoginData>(application) {

    private val signClient = SignClient()

    val onSuccessEvent = SingleLiveEvent<Unit>()
    val loginEvent = SingleLiveEvent<Unit>()
    val signUpEvent = SingleLiveEvent<Unit>()

    var request = LoginRequest()

    fun login() {
        addDisposable(signClient.login(request), dataObserver)
    }

    private fun insertLoginData(loginData: LoginData) {
        insertToken(loginData.token)
        insertId(loginData.user.id)
        insertUser(loginData.user)
    }

    private fun insertToken(token: String) {
        this.token = token
    }

    private fun insertUser(user: User) {
        CompositeDisposable().add(repository.insertUser(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { onSuccessEvent.call() },
                { error -> onErrorEvent.value = error }))
    }

    private fun insertId(id: String) {
        userId = id
    }

    fun onClickLoginBtn() {
        loginEvent.call()
    }

    fun onClickSignUpBtn() {
        signUpEvent.call()
    }

    override fun onRetrieveDataSuccess(data: LoginData) {
        insertLoginData(data)
    }

    override fun onRetrieveBaseSuccess(message: String) {
        onSuccessEvent.call()
    }
}