package com.example.simplemovie.data.movie.remote

import com.example.simplemovie.data.movie.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiClient {

    @GET("list/{id}")
    suspend fun getPopularMovie(
        @Path("id") id: Int
    ): MovieResponse

    @GET("list/{id}")
    suspend fun getTopRatedMovie(
        @Path("id") id: Int
    ): MovieResponse

}