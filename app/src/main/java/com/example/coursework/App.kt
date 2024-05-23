package com.example.coursework

import android.app.Application
import com.example.coursework.di.colorRecommendationsModule
import com.example.coursework.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(
                networkModule,
                colorRecommendationsModule,
            )
        }
    }
}