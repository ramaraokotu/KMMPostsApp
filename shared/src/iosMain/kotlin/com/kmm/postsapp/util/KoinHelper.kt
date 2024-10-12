package com.kmm.postsapp.util

import com.kmm.postsapp.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}