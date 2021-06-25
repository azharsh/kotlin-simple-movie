package com.example.simplemovie.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.simplemovie.data.movie.model.MovieEntity


@Database(
    entities = [
     MovieEntity::class
    ], version = 1
)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(
            context: Context,
            databaseName: String
        ): AppDatabase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    databaseName
                )
                    .fallbackToDestructiveMigration()
                INSTANCE = builder.build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

//    abstract fun formDao(): FormDao

}
