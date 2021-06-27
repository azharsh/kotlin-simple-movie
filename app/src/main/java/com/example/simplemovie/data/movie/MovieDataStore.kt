package com.example.simplemovie.data.movie

import com.example.simplemovie.data.movie.local.PopularDao
import com.example.simplemovie.data.movie.local.TopRatedDao
import com.example.simplemovie.data.movie.model.MovieModel
import com.example.simplemovie.data.movie.model.MovieResponse
import com.example.simplemovie.data.movie.model.PopularEntity
import com.example.simplemovie.data.movie.model.TopRatedEntity
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
                    it.id ?:1,
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

        topRatedDao.getAll().forEach {
            listResponse.add(
                MovieModel(
                    it.id ?: 1,
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
        popularDao.updatePopular(movieModel.favorite, movieModel.id)
    }

    override suspend fun updateTopRated(movieModel: MovieModel) {
        topRatedDao.updateTopRated(movieModel.favorite, movieModel.id)
    }

    override suspend fun insertPopular(listMovie: List<MovieModel>) {
        val listPopular = mutableListOf<PopularEntity>()
        listMovie.forEach {
            listPopular.add(
                PopularEntity(
                    it.id,
                    it.adult,
                    it.backdrop_path,
                    it.originalTitle,
                    it.overview,
                    it.popularity,
                    it.poster_path,
                    it.release_date,
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
                    it.backdrop_path,
                    it.originalTitle,
                    it.overview,
                    it.popularity,
                    it.poster_path,
                    it.release_date,
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