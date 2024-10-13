package com.kmm.postsapp.data.repository

import com.kmm.postsapp.data.model.Post
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface PostRepository {
    suspend fun fetchPosts(): List<Post>
}

class PostRepositoryWrapper : KoinComponent {
    private val repository: PostRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(): List<Post>{
        return repository.fetchPosts()
    }
}