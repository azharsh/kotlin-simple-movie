package com.example.simplemovie.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment(val t : Int) : Fragment(t){

    var taskType: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachView()
    }

    override fun onDestroy() {
        detachView()
        super.onDestroy()
    }

    abstract fun attachView()

    abstract fun detachView()

}