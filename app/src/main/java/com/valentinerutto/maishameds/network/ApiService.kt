package com.valentinerutto.maishameds.network

import com.valentinerutto.maishameds.data.PostBody
import com.valentinerutto.maishameds.data.PostResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): Response<PostResponse>

    @POST("/posts")
    suspend fun createPost(@Body postBody: PostBody): Response<PostResponse.PostResponseItem>
}
