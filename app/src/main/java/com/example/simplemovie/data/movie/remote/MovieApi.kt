package com.example.simplemovie.data.movie.remote

import com.example.simplemovie.data.movie.model.MovieResponse

class MovieApi(val movieApiClient: MovieApiClient) : MovieApiClient {

    override suspend fun getPopularMovie(id: Int): MovieResponse {
       return movieApiClient.getPopularMovie(id)
    }

    override suspend fun getTopRatedMovie(id: Int): MovieResponse {
        return movieApiClient.getTopRatedMovie(id)
    }
}