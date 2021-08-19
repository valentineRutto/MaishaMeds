package com.valentinerutto.maishameds.data

import com.valentinerutto.maishameds.network.ApiService
import com.valentinerutto.maishameds.util.NetworkResult
import com.valentinerutto.maishameds.util.safeApiCall
import kotlinx.coroutines.Dispatchers

class PostsRepository(private val apiService: ApiService) {
    suspend fun createPost(body: PostBody): NetworkResult<PostResponse.PostResponseItem?> {
        return safeApiCall(Dispatchers.IO) {
            apiService.createPost(body).body()
        }
    }
}
