package com.kmm.postsapp.android

import android.app.Application
import com.kmm.postsapp.android.di.appModule
import com.kmm.postsapp.di.getSharedModules
import org.koin.core.context.startKoin

class PostApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}