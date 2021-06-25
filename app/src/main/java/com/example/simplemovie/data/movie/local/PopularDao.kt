package com.example.simplemovie.data.movie.local

import androidx.room.*
import com.example.simplemovie.data.movie.model.PopularEntity


@Dao
interface PopularDao {

    @Query("SELECT * FROM PopularEntity")
    suspend fun getAll(): List<PopularEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg data: List<PopularEntity>)

    @Update()
    suspend fun update(data: PopularEntity)

    @Query("DELETE FROM PopularEntity")
    suspend fun deleteAll()

}