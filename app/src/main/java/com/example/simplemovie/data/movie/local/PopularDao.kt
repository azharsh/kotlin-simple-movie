package com.example.simplemovie.data.movie.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplemovie.base.BaseDao
import com.example.simplemovie.data.movie.model.PopularEntity


@Dao
interface PopularDao : BaseDao<PopularEntity> {

    @Query("SELECT * FROM PopularEntity")
    suspend fun getAll(): List<PopularEntity>

    @Query("DELETE FROM PopularEntity")
    suspend fun deleteAll()

    @Query("UPDATE PopularEntity SET favorite = :fav WHERE id = :id")
    suspend fun updatePopular(fav : Boolean , id : Int)

}