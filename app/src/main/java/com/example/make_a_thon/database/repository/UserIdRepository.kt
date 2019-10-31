package com.example.make_a_thon.database.repository

import android.content.Context

import com.example.make_a_thon.database.sharedpreference.UserId

class UserIdRepository(private val context: Context) {
    val userId: UserId = UserId(context)

    fun setUserId(id: String) {
        UserId(context).id = id
    }
}