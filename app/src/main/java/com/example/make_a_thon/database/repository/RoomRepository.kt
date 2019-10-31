package com.example.make_a_thon.database.repository

import android.app.Application

import com.example.make_a_thon.database.dao.UserDao
import com.example.make_a_thon.database.database.RoomDatabase
import com.example.make_a_thon.model.user.User

import io.reactivex.Completable
import io.reactivex.Single

class RoomRepository(application: Application) {

    private var userDao: UserDao

    init {
        val database = RoomDatabase.getInstance(application)!!
        userDao = database.userDao()
    }

    fun insertUser(entity: User): Completable { return userDao.insert(entity) }
    fun updateUser(entity: User): Completable { return userDao.update(entity) }
    fun deletUser(entity: User): Completable { return userDao.delete(entity) }
    fun getUser(id: String): Single<User> {
        return userDao.getUser(id)
    }
}
