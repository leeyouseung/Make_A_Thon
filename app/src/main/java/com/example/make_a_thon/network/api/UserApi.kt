package com.example.make_a_thon.network.api

import com.example.make_a_thon.model.user.Profile
import com.example.make_a_thon.network.response.Response

import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserApi {

    @GET()
    fun getProfile(@Header("") token : String, @Path("") userId : String): Single<retrofit2.Response<Response<Profile>>>
}