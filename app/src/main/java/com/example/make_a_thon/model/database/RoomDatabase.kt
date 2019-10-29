package com.example.make_a_thon.model.database

import android.content.Context

import androidx.room.Database
import androidx.room.Room

import com.example.make_a_thon.model.dao.UserDao
import com.example.make_a_thon.model.entity.user.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class RoomDatabase : androidx.room.RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var instance: RoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): RoomDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        RoomDatabase::class.java, "flut_database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            return instance
        }
    }
}
