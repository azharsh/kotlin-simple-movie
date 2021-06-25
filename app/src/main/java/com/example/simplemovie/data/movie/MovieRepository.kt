package com.example.simplemovie.data.movie

import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.data.movie.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieRepository {

    suspend fun getPopularMovie(id: Int): MovieResponse

    suspend fun getTopRatedMovie(id: Int): MovieResponse

    suspend fun getPopularMovieLocal(): List<MovieModel>

    suspend fun getTopRatedMovieLocal(): List<MovieModel>

    suspend fun updatePopular(movieModel: MovieModel)

    suspend fun updateTopRated(movieModel: MovieModel)

    suspend fun insertPopular(listMovie : List<MovieModel>)

    suspend fun insertTopRated(listMovie : List<MovieModel>)

}