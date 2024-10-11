package com.kmm.postsapp.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class PostsResponse(
    val posts: List<Post>
)
