package com.example.simplemovie.data.movie

import com.example.simplemovie.data.movie.local.PopularDao
import com.example.simplemovie.data.movie.local.TopRatedDao
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.data.movie.model.MovieResponse
import com.example.simplemovie.data.movie.model.PopularEntity
import com.example.simplemovie.data.movie.model.TopRatedEntity
import com.example.simplemovie.data.movie.remote.MovieApi

class MovieDataStore(
    val movieApi: MovieApi,
    val popularDao: PopularDao,
    val topRatedDao: TopRatedDao
) : MovieRepository {

    override suspend fun getPopularMovie(id: Int): MovieResponse {
        return movieApi.getPopularMovie(id)
    }

    override suspend fun getTopRatedMovie(id: Int): MovieResponse {
        return movieApi.getPopularMovie(id)
    }

    override suspend fun getPopularMovieLocal(): List<MovieModel> {

        val listResponse = mutableListOf<MovieModel>()

        popularDao.getAll().forEach {
            listResponse.add(
                MovieModel(
                    it.movie.id,
                    it.movie.adult,
                    it.movie.backdropPath,
                    it.movie.originalTitle,
                    it.movie.overview,
                    it.movie.popularity,
                    it.movie.posterPath,
                    it.movie.releaseDate,
                    it.movie.title,
                    it.movie.video,
                    it.movie.voteAverage,
                    it.movie.voteCount,
                    it.movie.favorite
                )
            )
        }


        return listResponse
    }

    override suspend fun getTopRatedMovieLocal(): List<MovieModel> {
        val listResponse = mutableListOf<MovieModel>()

        popularDao.getAll().forEach {
            listResponse.add(
                MovieModel(
                    it.movie.id,
                    it.movie.adult,
                    it.movie.backdropPath,
                    it.movie.originalTitle,
                    it.movie.overview,
                    it.movie.popularity,
                    it.movie.posterPath,
                    it.movie.releaseDate,
                    it.movie.title,
                    it.movie.video,
                    it.movie.voteAverage,
                    it.movie.voteCount,
                    it.movie.favorite
                )
            )
        }

        return listResponse
    }

    override suspend fun updatePopular(movieModel: MovieModel) {
        val popularEntity = PopularEntity(
            movieModel.id,
            movieModel
        )
        popularDao.update(popularEntity)
    }

    override suspend fun updateTopRated(movieModel: MovieModel) {
        val topRatedEntity = TopRatedEntity(
            movieModel.id,
            movieModel
        )
        topRatedDao.update(topRatedEntity)
    }

    override suspend fun insertPopular(listMovie: List<MovieModel>) {
        val listPopular = mutableListOf<PopularEntity>()
        listMovie.forEach {
            listPopular.add(
                PopularEntity(
                    it.id,
                    MovieModel(
                        it.id,
                        it.adult,
                        it.backdropPath,
                        it.originalTitle,
                        it.overview,
                        it.popularity,
                        it.posterPath,
                        it.releaseDate,
                        it.title,
                        it.video,
                        it.voteAverage,
                        it.voteCount,
                        it.favorite
                    )
                )
            )
        }
        popularDao.insert(listPopular)
    }

    override suspend fun insertTopRated(listMovie: List<MovieModel>) {
        val listTopRated = mutableListOf<TopRatedEntity>()
        listMovie.forEach {
            listTopRated.add(
                TopRatedEntity(
                    it.id,
                    MovieModel(
                        it.id,
                        it.adult,
                        it.backdropPath,
                        it.originalTitle,
                        it.overview,
                        it.popularity,
                        it.posterPath,
                        it.releaseDate,
                        it.title,
                        it.video,
                        it.voteAverage,
                        it.voteCount,
                        it.favorite
                    )
                )
            )
        }
        topRatedDao.insert(listTopRated)
    }
}