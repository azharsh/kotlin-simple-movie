package com.example.simplemovie.data.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity (
    @PrimaryKey(autoGenerate = false) var id: Int,
    var title: String
)