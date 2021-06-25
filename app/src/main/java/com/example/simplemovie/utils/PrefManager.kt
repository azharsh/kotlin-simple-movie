package com.example.simplemovie.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class PrefManager private constructor() {

    companion object {


        @Volatile
        private var instance: PrefManager? = null

        @Volatile
        private var preference: SharedPreferences? = null


        @SuppressLint("HardwareIds")
        @Synchronized
        fun init(context: Context) {
            if (instance == null) {
                instance = PrefManager()
            }
            if (preference == null) {
                val preferenceName = context.applicationContext.packageName + ".PREFERENCE_MANAGER"
                preference = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
            }
        }


        fun getInstance(): PrefManager {
            return instance ?: synchronized(this) {
                instance ?: PrefManager()
                    .also {
                        instance = it
                    }
            }
        }
    }
}