package com.example.gabriel.jsonplaceholder.data.local.entity.user

import com.google.gson.annotations.SerializedName

class Company(
    @SerializedName("name")
    val companyName: String?,

    val catchPhrase: String?,

    val bs: String?
)