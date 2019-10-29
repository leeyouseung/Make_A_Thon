package com.example.make_a_thon.model.repository

import android.content.Context

import com.example.make_a_thon.model.sharedpreference.UserId

class UserIdRepository(private val context: Context) {
    val userId: UserId = UserId(context)

    fun setUserId(id: String) {
        UserId(context).id = id
    }
}