package com.example.gabriel.jsonplaceholder.data.local.entity.user

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val uid: Int,

    val name: String,

    val username: String,

    val email: String,

    @Embedded
    val address: Address?,

    val phone: String,

    val website: String,

    @Embedded
    val company: Company?
)