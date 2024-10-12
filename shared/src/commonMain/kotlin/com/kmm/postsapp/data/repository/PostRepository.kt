package com.kmm.postsapp.data.repository

import com.kmm.postsapp.data.model.Post

internal interface PostRepository {
    suspend fun fetchPosts(): List<Post>
}
