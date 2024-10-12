package com.kmm.postsapp.android.di

import com.kmm.postsapp.android.ui.post_list_screen.PostViewModel
import org.koin.dsl.module

val appModule = module {
    single { PostViewModel(get()) }
}