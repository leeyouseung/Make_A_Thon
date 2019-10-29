package com.example.flut_fluss_kotlin.network.client

import com.example.flut_fluss_kotlin.base.BaseClient
import com.example.flut_fluss_kotlin.model.entity.user.User
import com.example.flut_fluss_kotlin.network.api.SignApi
import com.example.flut_fluss_kotlin.network.request.LoginRequest
import com.example.flut_fluss_kotlin.network.response.data.LoginData

import io.reactivex.Single

class SignClient : BaseClient<SignApi>() {

    fun login(loginRequest: LoginRequest): Single<LoginData> {

        return api.login(loginRequest).map(getResponseObjectsFunction())
    }

//    fun signUp(signUpRequest: SignUpRequest): Single<String> {
//        return api.signUp(signUpRequest).map(getResponseMessageFunction())
//    }

    fun autoLogin(token: String): Single<User> {

        return api.autoLogin(token).map(getResponseObjectsFunction())
    }

    override fun type(): Class<SignApi> {

        return SignApi::class.java
    }
}