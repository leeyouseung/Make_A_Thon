package com.example.make_a_thon.network.client

import com.example.make_a_thon.base.BaseClient
import com.example.make_a_thon.model.user.Profile
import com.example.make_a_thon.network.api.UserApi

import io.reactivex.Single

class UserClient : BaseClient<UserApi>() {

    fun getProfile(token: String, userId: String): Single<Profile> {
        return api.getProfile(token, userId).map(getResponseObjectsFunction())
    }

    override fun type(): Class<UserApi> {
        return UserApi::class.java
    }
}