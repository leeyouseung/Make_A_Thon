package com.example.make_a_thon.model.dao

import androidx.room.Dao
import androidx.room.Query

import com.example.make_a_thon.base.BaseDao
import com.example.make_a_thon.model.entity.user.User

import io.reactivex.Single

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM user_table WHERE id=:id")
    fun getUser(id: String?): Single<User>
}
