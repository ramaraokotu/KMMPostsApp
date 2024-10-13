package com.kmm.postsapp.di

import com.kmm.postsapp.data.datasource.PostDataSource
import com.kmm.postsapp.data.datasource.PostService
import com.kmm.postsapp.data.repository.PostRepository
import com.kmm.postsapp.data.repository.PostRepositoryImpl
import com.kmm.postsapp.util.GetPostsUseCase
import com.kmm.postsapp.util.provideDispatcher
import org.koin.dsl.module

private val dataSourceModule = module {
    factory { PostDataSource(get(), get()) }
    factory { PostService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<PostRepository> { PostRepositoryImpl(get()) }
}

private val sharedModules = listOf(domainModule, dataSourceModule, utilityModule)

fun getSharedModules() = sharedModules
