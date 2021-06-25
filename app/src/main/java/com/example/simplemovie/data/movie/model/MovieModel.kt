package com.example.simplemovie.data.movie.model

data class MovieModel(
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long,
    val favorite : Boolean
)


