package com.chandra.web2android.base

import android.app.Application
import com.chandra.web2android.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Web2AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Web2AndroidApp)
            modules(appModules)
        }
    }
}