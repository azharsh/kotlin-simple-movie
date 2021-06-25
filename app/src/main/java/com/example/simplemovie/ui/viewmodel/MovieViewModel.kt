package com.example.simplemovie.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemovie.data.movie.MovieRepository
import com.example.simplemovie.data.movie.model.MovieModel


class MovieViewModel(val movieRepository: MovieRepository) : ViewModel() {

    suspend fun getPopularMovie(): MutableLiveData<List<MovieModel>> {
        val result = MutableLiveData<List<MovieModel>>()
        try {
            val response = movieRepository.getPopularMovie(1)
            result.value = response.results
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

    suspend fun getTopRatedMovie(): MutableLiveData<List<MovieModel>> {
        val result = MutableLiveData<List<MovieModel>>()
        try {
            val response = movieRepository.getTopRatedMovie(2)
            result.value = response.results
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

    suspend fun getPopularMovieLocal(): MutableLiveData<List<MovieModel>> {
        val result = MutableLiveData<List<MovieModel>>()
        try {
            val response = movieRepository.getPopularMovieLocal()
            result.value = response
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

    suspend fun getTopRatedMovieLocal(): MutableLiveData<List<MovieModel>> {
        val result = MutableLiveData<List<MovieModel>>()
        try {
            val response = movieRepository.getTopRatedMovieLocal()
            result.value = response
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

    suspend fun updatePopular(movieModel: MovieModel) {
        movieRepository.updatePopular(movieModel)
    }

    suspend fun updateTopRated(movieModel: MovieModel) {
        movieRepository.updateTopRated(movieModel)
    }

    suspend fun insertPopular(listMovie: List<MovieModel>) {
        movieRepository.insertPopular(listMovie)
    }

    suspend fun insertTopRated(listMovie: List<MovieModel>) {
        movieRepository.insertTopRated(listMovie)
    }

}