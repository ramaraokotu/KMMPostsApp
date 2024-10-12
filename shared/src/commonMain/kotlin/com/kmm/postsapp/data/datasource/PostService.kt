package com.kmm.postsapp.data.datasource

import com.kmm.postsapp.data.model.Post
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class PostService : PostApi() {

    suspend fun getPosts(): List<Post> = client.get {
        pathUrl()
    }.body()
}