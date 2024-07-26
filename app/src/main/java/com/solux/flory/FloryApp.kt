package com.solux.flory

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class FloryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setTimber()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }
}