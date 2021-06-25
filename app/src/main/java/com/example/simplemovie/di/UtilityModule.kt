package com.example.simplemovie.di

import com.google.gson.Gson
import org.greenrobot.eventbus.EventBus
import org.koin.dsl.module


val utilityModule = module {

    single { Gson() }

    single { EventBus() }

}