package com.valentinerutto.maishameds.data


import com.google.gson.annotations.SerializedName

data class PostBody(
    @SerializedName("body")
    val body: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
)