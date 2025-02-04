package com.example.make_a_thon.network.client

import com.example.make_a_thon.base.BaseClient
import com.example.make_a_thon.network.api.SignApi
import com.example.make_a_thon.network.request.LoginRequest
import com.example.make_a_thon.network.request.SignUpRequest
import com.example.make_a_thon.network.response.data.LoginData

import io.reactivex.Single

class SignClient : BaseClient<SignApi>() {

    fun login(loginRequest: LoginRequest): Single<LoginData> {
        return api.login(loginRequest).map(getResponseObjectsFunction())
    }

    fun signUp(signUpRequest: SignUpRequest): Single<String> {
        return api.signUp(signUpRequest).map(getResponseMessageFunction())
    }

    override fun type(): Class<SignApi> {

        return SignApi::class.java
    }
}