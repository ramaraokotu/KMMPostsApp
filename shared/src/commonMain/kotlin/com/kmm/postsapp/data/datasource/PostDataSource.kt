package com.kmm.postsapp.data.datasource

import com.kmm.postsapp.util.Dispatcher
import kotlinx.coroutines.withContext

internal class PostDataSource(
    private val apiService: PostService,
    private val dispatcher: Dispatcher
) {

    suspend fun getPosts() = withContext(dispatcher.io) {
        apiService.getPosts()
    }
}