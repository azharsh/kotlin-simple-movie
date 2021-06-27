package com.example.simplemovie.data.movie.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class PopularEntity (
    @PrimaryKey(autoGenerate = false) var id: Int? = null,
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
) : Serializable


