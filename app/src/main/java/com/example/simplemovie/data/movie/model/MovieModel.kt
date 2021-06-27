package com.example.simplemovie.data.movie.model

data class MovieModel(
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    var favorite : Boolean? = false
)


