package com.valentinerutto.maishameds.data


import com.google.gson.annotations.SerializedName

class PostResponse : ArrayList<PostResponse.PostResponseItem>(){
    data class PostResponseItem(
        @SerializedName("body")
        val body: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("userId")
        val userId: Int?
    )
}