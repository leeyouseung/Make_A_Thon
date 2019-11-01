package com.example.make_a_thon.network.api

import com.example.make_a_thon.model.user.Profile
import com.example.make_a_thon.network.response.Response

import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.Header

interface UserApi {

    @GET("/getProfile")
    fun getProfile(@Header("Authorization") token : String): Single<retrofit2.Response<Response<Profile>>>
}