package com.example.gabriel.jsonplaceholder.data.local.entity.user

import androidx.room.Embedded

class Address(
    val street: String,

    val suite: String?,

    val city: String?,

    val zipcode: String?,

    @Embedded
    val geo: Geo?
)