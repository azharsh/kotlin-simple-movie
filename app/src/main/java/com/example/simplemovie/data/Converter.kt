package com.example.simplemovie.data

import androidx.room.TypeConverter
import com.example.simplemovie.data.movie.model.PopularEntity
import com.example.simplemovie.data.movie.model.TopRatedEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListStringConverter {
    @TypeConverter
    fun storedStringToList(value: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun listToStoredString(list: List<String>): String {
        return Gson().toJson(list)
    }
}


class ListPopularStringConverter {
    @TypeConverter
    fun storedStringToList(value: String): List<PopularEntity> {
        val type = object : TypeToken<List<PopularEntity>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun listToStoredString(list: List<PopularEntity>): String {
        return Gson().toJson(list)
    }
}


class ListTopRatedStringConverter {
    @TypeConverter
    fun storedStringToList(value: String): List<TopRatedEntity> {
        val type = object : TypeToken<List<TopRatedEntity>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun listToStoredString(list: List<TopRatedEntity>): String {
        return Gson().toJson(list)
    }
}


