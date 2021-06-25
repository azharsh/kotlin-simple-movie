package com.example.simplemovie.app

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.example.simplemovie.di.apiModule
import com.example.simplemovie.di.dbModule
import com.example.simplemovie.di.feature.movieModule
import com.example.simplemovie.di.preferenceModule
import com.example.simplemovie.di.utilityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SimpleMovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        startKoin {

            androidLogger()

            androidContext(this@SimpleMovieApp)

            modules(
                listOf(
                    apiModule,
                    dbModule,
                    preferenceModule,
                    utilityModule,
                    movieModule
                )
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }
}