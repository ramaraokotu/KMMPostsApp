package com.kmm.postsapp.android.di

import com.kmm.postsapp.android.ui.PostListScreen.PostViewModel
import org.koin.dsl.module

val appModule = module {
    single { PostViewModel(get()) }
}