package com.example.simplemovie.ui

import android.os.Bundle
import com.example.simplemovie.base.BaseActivity
import com.example.simplemovie.databinding.ActivityDetailBinding


class DetailActivity : BaseActivity() {


    private lateinit var binding : ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }

    override fun attachView() {

    }

    override fun detachView() {

    }
}