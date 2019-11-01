package com.example.make_a_thon.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(@field:PrimaryKey
                var id: String,
                var password: String,
                var name: String?,
                var phoneNumber: String?)
