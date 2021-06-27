package com.example.simplemovie.data.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity
data class TopRatedEntity(
    @PrimaryKey(autoGenerate = false) var id: Int,
    var adult: Boolean? = null,
    var backdropPath: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var title: String? = null,
    var video: Boolean? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null,
    var favorite : Boolean? = null
)