package com.kmm.postsapp.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.kmm.postsapp.android.R
import com.kmm.postsapp.android.ui.post_list_screen.PostViewModel
import com.kmm.postsapp.android.ui.post_list_screen.PostsListRoute
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel: PostViewModel by inject()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Scaffold(topBar = {
                    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White
                    ), title = { Text(text = stringResource(id = R.string.app_name)) })
                })
                { padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .background(Color.White),
                    ) {
                        PostsListRoute(viewModel)
                    }
                }
            }
        }
    }
}

