package com.kmm.postsapp.data.datasource

import com.kmm.postsapp.data.model.PostsResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class PostService : PostApi() {

    suspend fun getPosts(): PostsResponse = client.get {
        pathUrl()
    }.body()
}