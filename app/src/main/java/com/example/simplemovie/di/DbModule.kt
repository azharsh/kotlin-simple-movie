package com.example.simplemovie.di



import com.example.simplemovie.data.AppDatabase
import org.koin.dsl.module

const val DATABASE_NAME = "playground-database"

val dbModule = module {

    single { AppDatabase.getAppDatabase(get(), DATABASE_NAME) }

//    single {
//        val appDatabase: AppDatabase = get()
//        return@single appDatabase.formDao()
//    }
//
//    single {
//        val appDatabase: AppDatabase = get()
//        return@single appDatabase.diaryDao()
//    }


}