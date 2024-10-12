package com.kmm.postsapp.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kmm.postsapp.data.model.Post
import com.kmm.postsapp.ui.PostViewModel
import com.kmm.postsapp.util.UiState

@Composable
fun PostsListRoute(viewModel: PostViewModel) {

    val uiState: UiState<List<Post>> by viewModel.uiState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.padding(4.dp)) {
        PostsListScreen(uiState)
    }
}

@Composable
fun PostsListScreen(
    uiState: UiState<List<Post>>
) {
    when (uiState) {
        is UiState.Success -> {
            PostsList(uiState.data)
        }

        is UiState.Loading -> {
            ShowLoading()
        }

        is UiState.Error -> {
            ShowError(text = uiState.message)
        }
    }
}