package com.valentinerutto.maishameds.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.valentinerutto.maishameds.data.PostBody
import com.valentinerutto.maishameds.data.PostResponse
import com.valentinerutto.maishameds.data.PostsRepository
import com.valentinerutto.maishameds.util.NetworkResult

class PostsViewModel(private val postsRepository: PostsRepository) : ViewModel() {
    suspend fun createPost(body: PostBody): NetworkResult<PostResponse.PostResponseItem?> {
        return postsRepository.createPost(body)
    }
}
