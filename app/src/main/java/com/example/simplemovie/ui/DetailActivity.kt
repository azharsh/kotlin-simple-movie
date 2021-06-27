package com.example.simplemovie.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.simplemovie.R
import com.example.simplemovie.base.BaseActivity
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.databinding.ActivityDetailBinding
import com.example.simplemovie.ui.viewmodel.MovieViewModel
import com.example.simplemovie.utils.Constant.API_KEY
import com.example.simplemovie.utils.Constant.IMG_URL
import com.example.simplemovie.utils.launch
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject


class DetailActivity : BaseActivity() {

    private lateinit var binding : ActivityDetailBinding

    private val movieViewModel: MovieViewModel by inject()

    var movieData : MovieModel ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val gson = Gson()
        val data = intent.getStringExtra("moviedata")
        movieData = gson.fromJson(data, MovieModel::class.java)

        binding.titleDetail.text = movieData?.title
        val imgUrl = IMG_URL + movieData?.poster_path + "?api_key=" + API_KEY

        Picasso.get().load(imgUrl)
            .into(binding.imgDetail)

        binding.descDetail.text = movieData?.overview

        setFav()

        binding.favDetail.setOnClickListener {
            movieData?.favorite = !movieData?.favorite!!
            setFav()
            updateMovie()
        }

    }

    private fun updateMovie(){
        launch {
            movieViewModel.getPopularMovieLocal().observe(this, Observer {
                it.forEach { m ->
                    if (m.id == movieData?.id) {
                        launch {
                            movieViewModel.updatePopular(movieData!!)
                        }
                    }
                }
            })
            movieViewModel.getTopRatedMovieLocal().observe(this, Observer {
                it.forEach { m ->
                    if (m.id == movieData?.id) {
                        launch {
                            movieViewModel.updateTopRated(movieData!!)
                        }
                    }
                }
            })
        }
    }

    private fun setFav(){
        if (movieData?.favorite == true){
            binding.favDetail.setImageResource(R.drawable.ic_baseline_favorite_24_red)
        }else{
            binding.favDetail.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }

    override fun attachView() {

    }

    override fun detachView() {

    }
}