package com.example.simplemovie.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        protected var activities: ArrayList<BaseActivity> = arrayListOf()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activities.add(this)
        attachView()
    }

    override fun onPause() {
        detachView()
        super.onPause()
    }

    override fun onDestroy() {
        detachView()
        activities.remove(this)
        super.onDestroy()
    }

    abstract fun attachView()

    abstract fun detachView()
}