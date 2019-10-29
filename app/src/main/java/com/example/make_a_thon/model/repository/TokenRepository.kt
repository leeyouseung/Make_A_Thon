package com.example.make_a_thon.model.repository

import android.content.Context

import com.example.make_a_thon.model.sharedpreference.Token

class TokenRepository(private val context: Context) {
    val token: Token = Token(context)

    fun setToken(token: String) {
        Token(context).token = token
    }
}