package com.example.simplemovie.ui

import android.os.Bundle
import com.example.simplemovie.R
import com.example.simplemovie.base.BaseActivity
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.databinding.ActivityDetailBinding
import com.example.simplemovie.utils.Constant.API_KEY
import com.example.simplemovie.utils.Constant.IMG_URL
import com.google.gson.Gson
import com.squareup.picasso.Picasso


class DetailActivity : BaseActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val gson = Gson()
        val data = intent.getStringExtra("moviedata")
        val movieData = gson.fromJson(data, MovieModel::class.java)

        binding.titleDetail.text = movieData.title
        val imgUrl = IMG_URL + movieData.poster_path + "?api_key=" + API_KEY

        Picasso.get().load(imgUrl)
            .into(binding.imgDetail)

        binding.descDetail.text = movieData.overview

        if (movieData.favorite){
            binding.favDetail.setImageResource(R.drawable.ic_baseline_favorite_24_red)
        }

        binding.favDetail.setOnClickListener {

        }

    }

    override fun attachView() {

    }

    override fun detachView() {

    }
}