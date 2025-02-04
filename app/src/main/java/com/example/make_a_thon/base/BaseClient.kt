package com.example.make_a_thon.base

import com.example.make_a_thon.network.response.Response
import com.example.make_a_thon.util.Utils

import io.reactivex.functions.Function

import org.json.JSONObject

import java.util.*

abstract class BaseClient<V> {

    protected val api: V
        get() = Utils.RETROFIT.create(type())

    protected fun <T> getResponseObjectsFunction(): Function<retrofit2.Response<Response<T>>, T> {
        return Function { response: retrofit2.Response<Response<T>> -> checkError(response)
            response.body()!!.data
        }
    }

    protected fun getResponseMessageFunction(): Function<retrofit2.Response<Response<Any>>, String> {
        return Function { response: retrofit2.Response<Response<Any>> -> checkError(response)
            response.body()!!.message
        }
    }

    private fun checkError(response: retrofit2.Response<*>) {
        if (!response.isSuccessful) {
            val errorBody = JSONObject(Objects.requireNonNull(response.errorBody())?.string())
            throw Exception(errorBody.getString("message"))
        }
    }

    protected abstract fun type(): Class<V>
}