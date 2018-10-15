package com.example.gabriel.jsonplaceholder.data.local.entity.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.gabriel.jsonplaceholder.data.local.entity.user.User
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "posts",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Post(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val pid: Int,

    val userId: Int,

    val title: String,

    val body: String
)