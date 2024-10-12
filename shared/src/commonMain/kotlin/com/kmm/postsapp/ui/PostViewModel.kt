package com.kmm.postsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmm.postsapp.data.model.Post
import com.kmm.postsapp.data.repository.PostRepository
import com.kmm.postsapp.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<Post>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Post>>> get() = _uiState

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val posts = postRepository.fetchPosts()
                _uiState.value = UiState.Success(posts)
            } catch (e: Exception) {
                _uiState.value =
                    UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}