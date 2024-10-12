package com.kmm.postsapp.android

import android.app.Application
import com.kmm.postsapp.di.getSharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PostApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PostApplication)
            androidLogger()
            modules(getSharedModules())
        }
    }
}