package com.kmm.postsapp.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmm.postsapp.android.R
import com.kmm.postsapp.data.model.Post

@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val contentDesc = stringResource(id = R.string.loading_message)
        CircularProgressIndicator(modifier = Modifier
            .align(Alignment.Center)
            .semantics {
                contentDescription = contentDesc
            })
    }

}

@Composable
fun ShowError(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.error_message),
            style = MaterialTheme.typography.titleMedium,
            color = Color.Red,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(5.dp)
        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
        )

    }

}

@Composable
fun PostsList(articles: List<Post>) {
    LazyColumn {
        items(articles.size) { index ->
            Post(post = articles[index])
        }
    }
}

@Composable
fun Post(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TitleText(post.title)
        DescriptionText(post.body)
    }

}


@Composable
fun TitleText(title: String) {
    if (title.isNotEmpty()) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontSize = 18.sp,
            maxLines = 2,
            modifier = Modifier.padding(5.dp)
        )
    }
}


@Composable
fun DescriptionText(description: String?) {
    if (!description.isNullOrEmpty()) {
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            fontSize = 16.sp,
            maxLines = 3,
            modifier = Modifier.padding(5.dp)
        )
    }
}
