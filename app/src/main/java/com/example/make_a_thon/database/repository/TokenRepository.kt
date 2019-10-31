package com.example.make_a_thon.database.repository

import android.content.Context

import com.example.make_a_thon.database.sharedpreference.Token

class TokenRepository(private val context: Context) {
    val token: Token = Token(context)

    fun setToken(token: String) {
        Token(context).token = token
    }
}