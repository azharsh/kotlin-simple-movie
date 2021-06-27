package com.example.simplemovie.data.movie.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplemovie.base.BaseDao

import com.example.simplemovie.data.movie.model.TopRatedEntity

@Dao
interface TopRatedDao : BaseDao<TopRatedEntity> {

    @Query("SELECT * FROM TopRatedEntity")
    suspend fun getAll(): List<TopRatedEntity>

    @Query("DELETE FROM TopRatedEntity")
    suspend fun deleteAll()

    @Query("UPDATE TopRatedEntity SET favorite = :fav WHERE id = :id")
    suspend fun updateTopRated(fav : Boolean , id : Int)
}