package com.kmm.postsapp.data.repository

import com.kmm.postsapp.data.datasource.PostDataSource
import com.kmm.postsapp.data.model.Post


internal class PostRepositoryImpl(
    private val remoteDateSource: PostDataSource
) : PostRepository {

    override suspend fun fetchPosts(): List<Post> {
        return remoteDateSource.getPosts()
    }
}
