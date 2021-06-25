package com.example.simplemovie.data.movie.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.simplemovie.data.movie.model.PopularEntity
import com.example.simplemovie.data.movie.model.TopRatedEntity

interface TopRatedDao {

    @Query("SELECT * FROM TopRatedEntity")
    suspend fun getAll(): List<TopRatedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg data: List<TopRatedEntity>)

    @Update()
    suspend fun update(data: TopRatedEntity)

    @Query("DELETE FROM TopRatedEntity")
    suspend fun deleteAll()
}