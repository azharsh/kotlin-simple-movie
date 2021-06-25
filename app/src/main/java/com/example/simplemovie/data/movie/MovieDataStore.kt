package com.example.simplemovie.data.movie

import com.example.simplemovie.data.movie.local.PopularDao
import com.example.simplemovie.data.movie.local.TopRatedDao
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.data.movie.model.MovieResponse
import com.example.simplemovie.data.movie.model.PopularEntity
import com.example.simplemovie.data.movie.model.TopRatedEntity
import com.example.simplemovie.data.movie.remote.MovieApi
import com.example.simplemovie.data.movie.remote.MovieApiClient

class MovieDataStore(
    private val movieApi: MovieApiClient,
    private val popularDao: PopularDao,
    private val topRatedDao: TopRatedDao
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
                    it.id,
                    it.adult ?: false,
                    it.backdropPath.orEmpty(),
                    it.originalTitle.orEmpty(),
                    it.overview.orEmpty(),
                    it.popularity ?: 0.0,
                    it.posterPath.orEmpty(),
                    it.releaseDate.orEmpty(),
                    it.title.orEmpty(),
                    it.video ?: false,
                    it.voteAverage ?: 0.0,
                    it.voteCount ?:0,
                    it.favorite ?: false
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
                    it.id,
                    it.adult ?: false,
                    it.backdropPath.orEmpty(),
                    it.originalTitle.orEmpty(),
                    it.overview.orEmpty(),
                    it.popularity ?: 0.0,
                    it.posterPath.orEmpty(),
                    it.releaseDate.orEmpty(),
                    it.title.orEmpty(),
                    it.video ?: false,
                    it.voteAverage ?: 0.0,
                    it.voteCount ?:0,
                    it.favorite ?: false
                )
            )
        }

        return listResponse
    }

    override suspend fun updatePopular(movieModel: MovieModel) {
        val popularEntity = PopularEntity(
            movieModel.id,
            movieModel.adult,
            movieModel.backdropPath,
            movieModel.originalTitle,
            movieModel.overview,
            movieModel.popularity,
            movieModel.poster_path,
            movieModel.releaseDate,
            movieModel.title,
            movieModel.video,
            movieModel.voteAverage,
            movieModel.voteCount,
            movieModel.favorite
        )
        popularDao.update(popularEntity)
    }

    override suspend fun updateTopRated(movieModel: MovieModel) {
        val topRatedEntity = TopRatedEntity(
            movieModel.id,
            movieModel.adult,
            movieModel.backdropPath,
            movieModel.originalTitle,
            movieModel.overview,
            movieModel.popularity,
            movieModel.poster_path,
            movieModel.releaseDate,
            movieModel.title,
            movieModel.video,
            movieModel.voteAverage,
            movieModel.voteCount,
            movieModel.favorite
        )
        topRatedDao.update(topRatedEntity)
    }

    override suspend fun insertPopular(listMovie: List<MovieModel>) {
        val listPopular = mutableListOf<PopularEntity>()
        listMovie.forEach {
            listPopular.add(
                PopularEntity(
                    it.id,
                    it.adult,
                    it.backdropPath,
                    it.originalTitle,
                    it.overview,
                    it.popularity,
                    it.poster_path,
                    it.releaseDate,
                    it.title,
                    it.video,
                    it.voteAverage,
                    it.voteCount,
                    it.favorite

                )
            )
        }
        popularDao.insertAll(listPopular)
    }

    override suspend fun insertTopRated(listMovie: List<MovieModel>) {
        val listTopRated = mutableListOf<TopRatedEntity>()
        listMovie.forEach {
            listTopRated.add(
                TopRatedEntity(
                    it.id,
                    it.adult,
                    it.backdropPath,
                    it.originalTitle,
                    it.overview,
                    it.popularity,
                    it.poster_path,
                    it.releaseDate,
                    it.title,
                    it.video,
                    it.voteAverage,
                    it.voteCount,
                    it.favorite
                )
            )
        }
        topRatedDao.insertAll(listTopRated)
    }
}