package com.example.simplemovie.di.feature

import com.example.simplemovie.data.movie.MovieDataStore
import com.example.simplemovie.data.movie.MovieRepository
import com.example.simplemovie.ui.viewmodel.MovieViewModel


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  movieModule = module {

    single<MovieRepository> { MovieDataStore(get(), get(), get()) }

    viewModel { MovieViewModel(get()) }

}