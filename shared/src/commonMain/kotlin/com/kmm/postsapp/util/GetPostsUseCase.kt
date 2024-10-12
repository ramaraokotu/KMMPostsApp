package com.kmm.postsapp.util

import com.kmm.postsapp.data.model.Post
import com.kmm.postsapp.data.repository.PostRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPostsUseCase: KoinComponent {
    private val repository: PostRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(): List<Post>{
        return repository.fetchPosts()
    }
}